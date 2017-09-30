/*
 * WhenExecutor.cpp
 *
 *  Created on: Sep 20, 2017
 *      Author: arthur moua


 */



#include <vector>
#include "WhenExecutor.h"
#include "StatementExecutor.h"
#include "ExpressionExecutor.h"
#include "../../../DataValue.h"
#include "../../../intermediate/ICodeNode.h"
#include "../../../intermediate/icodeimpl/ICodeNodeImpl.h"

namespace wci { namespace backend { namespace interpreter { namespace executors {

using namespace std;
using namespace wci;
using namespace wci::backend::interpreter;
using namespace wci::intermediate;
using namespace wci::intermediate::icodeimpl;

WhenExecutor::WhenExecutor(Executor *parent)
    : StatementExecutor(parent)
{
}

DataValue *WhenExecutor::execute(ICodeNode *node)
{
    // Get the IF node's children.
    vector<ICodeNode *> children = node->get_children();
    ICodeNode *expr_node = children[0];
    ICodeNode *right_arrow_stmt_node = children[1];
    ICodeNode *next_expr_node = children[2];
 //   ICodeNode *otherwise_stmt_node = children.size > 2 ? children[3] : nullptr;

    ExpressionExecutor expression_executor(this);
    StatementExecutor statement_executor(this);

    // Evaluate the boolean expression to determine which statement subtree child to execute.
    DataValue *data_value = expression_executor.execute(expr_node);
    //create another dtate value to evaluate the boolean expr.
    if (data_value->b)
    {
        statement_executor.execute(right_arrow_stmt_node);
    }
    else if (next_expr_node != nullptr)
    {
        statement_executor.execute(right_arrow_stmt_node);
    }
 //   else if (otherwise_stmt_node != nullptr)
   // {
  /// 	statement_executor.execute(otherwise_stmt_node);
   // }

    ++execution_count;  // count the WHEN statement itself
    return nullptr;
}

}}}}  // namespace wci::backend::interpreter::executors

