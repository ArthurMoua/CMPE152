/*
 * WhenStatementParser.cpp
 *
 *  Created on: Sep 20, 2017
 *      Author: arthur moua
 */
#include <string>
#include <set>
#include "WhenStatementParser.h"
#include "StatementParser.h"
#include "AssignmentStatementParser.h"
#include "ExpressionParser.h"
#include "../PascalParserTD.h"
#include "../PascalToken.h"
#include "../PascalError.h"
#include "../../Token.h"
#include "../../../intermediate/ICodeNode.h"
#include "../../../intermediate/ICodeFactory.h"
#include "../../../intermediate/icodeimpl/ICodeNodeImpl.h"

namespace wci { namespace frontend { namespace pascal { namespace parsers {

using namespace std;
using namespace wci::frontend::pascal;
using namespace wci::intermediate;
using namespace wci::intermediate::icodeimpl;

bool WhenStatementParser::INITIALIZED = false;

set<PascalTokenType> WhenStatementParser::RIGHT_ARROW_SET;

void WhenStatementParser::initialize()
{
    if (INITIALIZED) return;

    RIGHT_ARROW_SET = StatementParser::STMT_START_SET;
    RIGHT_ARROW_SET.insert(PascalTokenType::RIGHT_ARROW);

    set<PascalTokenType>::iterator it;
    for (it  = StatementParser::STMT_FOLLOW_SET.begin();
         it != StatementParser::STMT_FOLLOW_SET.end();
         it++)
    {
    	RIGHT_ARROW_SET.insert(*it);
    }

    INITIALIZED = true;
}

WhenStatementParser::WhenStatementParser(PascalParserTD *parent)
    : StatementParser(parent)
{
    initialize();
}

ICodeNode *WhenStatementParser::parse_statement(Token *token) throw (string)
{
    token = next_token(token);  // consume the WHEN token

    // Create a WHEN node.
    ICodeNode *when_node = ICodeFactory::create_icode_node((ICodeNodeType) NT_WHEN);


    // Parse the expression.
    // The IF node adopts the expression subtree as its first child.
    ExpressionParser expression_parser(this);
    when_node->add_child(expression_parser.parse_statement(token));

    // Synchronize at the RIGHT_ARROW.
    token = synchronize(RIGHT_ARROW_SET);
    if (token->get_type() == (TokenType) PT_RIGHT_ARROW)
    {
        token = next_token(token);  // consume the RIGHT_ARROW
    }
    else {
        error_handler.flag(token, MISSING_THEN, this);
    }

    // Parse the RIGHT_ARROW statement.
    // The WHEN node adopts the statement subtree as its second child.
    StatementParser statement_parser(this);
    when_node->add_child(statement_parser.parse_statement(token));
    token = current_token();

    // Look for an OTHERWISE.
/*    if (token->get_type() == (TokenType) PT_OTHERWISE)
    {
        token = next_token(token);  // consume the THEN

        // Parse the ELSE statement.
        // The IF node adopts the statement subtree as its third child.
        when_node->add_child(statement_parser.parse_statement(token));
    }*/

    while (token->get_type() != (TokenType) PT_OTHERWISE)
    {
        token = next_token(token);  //move to next token
	if(token->get_type() == (TokenType) PT_OTHERWISE) break;

        ICodeNode *when_branch_node = ICodeFactory::create_icode_node((ICodeNodeType) NT_WHEN_BRANCH);
        when_node->add_child(when_branch_node);
        ExpressionParser expression_parser(this);
        when_branch_node->add_child(expression_parser.parse_statement(token));

        // Synchronize at the RIGHT_ARROW.
        token = synchronize(RIGHT_ARROW_SET);
        if (token->get_type() == (TokenType) PT_RIGHT_ARROW)
        {
            token = next_token(token);  // consume the RIGHT_ARROW
        }
        else {
            error_handler.flag(token, MISSING_RIGHT_ARROW, this);
        }

        // Parse the RIGHT_ARROW statement.
        // The WHEN node adopts the statement subtree as its second child.
        StatementParser statement_parser(this);
        when_branch_node->add_child(statement_parser.parse_statement(token));
        token = current_token();

    }

    if (token->get_type() == (TokenType) PT_OTHERWISE)
        {
            token = next_token(token);  // consume the OTHERWISE
	    token = next_token(token);  // consume the RIGHT_ARROW

            // Parse the OTHERWISE statement.
            // The WHEN node adopts the statement subtree as its last child.
            when_node->add_child(statement_parser.parse_statement(token));
        }

	token = next_token(token); // consume the END token

    return when_node;
}

}}}}  // namespace wci::frontend::pascal::parsers



