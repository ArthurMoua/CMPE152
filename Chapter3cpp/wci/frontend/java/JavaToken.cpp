/**
 * <h1>JavaToken</h1>
 *
 * <p>Base class for Java token classes.</p>
 *
 * <p>Copyright (c) 2017 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
#include <string>
#include <vector>
#include <map>
#include "JavaToken.h"

namespace wci { namespace frontend { namespace java {

using namespace std;

map<string, JavaTokenType> JavaToken::RESERVED_WORDS;
map<string, JavaTokenType> JavaToken::SPECIAL_SYMBOLS;
map<JavaTokenType, string> JavaToken::SPECIAL_SYMBOL_NAMES;

bool JavaToken::INITIALIZED = false;

void JavaToken::initialize()
{
    if (INITIALIZED) return;

    vector<string> rw_strings =
    {
        "AND", "ARRAY", "BEGIN", "CASE", "CONST", "DIV", "DO", "DOWNTO",
        "ELSE", "END", "FILE", "FOR", "FUNCTION", "GOTO", "IF", "IN",
        "LABEL", "MOD", "NIL", "NOT", "OF", "OR", "PACKED", "PROCEDURE",
        "PROGRAM", "RECORD", "REPEAT", "SET", "THEN", "TO", "TYPE",
        "UNTIL", "VAR", "WHILE", "WITH"
    };

    vector<JavaTokenType> rw_keys =
    {
        JavaTokenType::AND,
        JavaTokenType::ARRAY,
        JavaTokenType::BEGIN,
        JavaTokenType::CASE,
        JavaTokenType::CONST,
        JavaTokenType::DIV,
        JavaTokenType::DO,
        JavaTokenType::DOWNTO,

        JavaTokenType::ELSE,
        JavaTokenType::END,
        JavaTokenType::FILE,
        JavaTokenType::FOR,
        JavaTokenType::FUNCTION,
        JavaTokenType::GOTO,
        JavaTokenType::IF,
        JavaTokenType::IN,

        JavaTokenType::LABEL,
        JavaTokenType::MOD,
        JavaTokenType::NIL,
        JavaTokenType::NOT,
        JavaTokenType::OF,
        JavaTokenType::OR,
        JavaTokenType::PACKED,
        JavaTokenType::PROCEDURE,

        JavaTokenType::PROGRAM,
        JavaTokenType::RECORD,
        JavaTokenType::REPEAT,
        JavaTokenType::SET,
        JavaTokenType::THEN,
        JavaTokenType::TO,
        JavaTokenType::TYPE,

        JavaTokenType::UNTIL,
        JavaTokenType::VAR,
        JavaTokenType::WHILE,
        JavaTokenType::WITH
    };

    for (int i = 0; i < rw_strings.size(); i++)
    {
        RESERVED_WORDS[rw_strings[i]] = rw_keys[i];
    }

    vector<string> ss_strings =
    {
        "~", "!", "@", "%", "^", "&", "*", "-", "+", "=",
		"|", "/", ":", ";", "?", "<", ">", ".", ",",
		"'", "\"", "(", ")","[", "]","{", "}",
        "++", "--", "<<", ">>", "<=", ">=", "+=", "-=", "*=", "/=",
		"==", "|=", "%=", "&=", "^=", "!=", "<<=", ">>=", "||", "&&",
		"//", "/*", "*/"
    };

    vector<JavaTokenType> ss_keys =
    {
           JavaTokenType::TILDE,
		   JavaTokenType::EXCLAMATION,
		   JavaTokenType::AT,
		   JavaTokenType::PERCENT,
		   JavaTokenType::HAT,
		   JavaTokenType::AMPERSAND,
		   JavaTokenType::MULT,
		   JavaTokenType::MINUS,
		   JavaTokenType::PLUS,
		   JavaTokenType::EQUALS,

           JavaTokenType::BIT_OR,
		   JavaTokenType::SLASH,
		   JavaTokenType::COLON,
		   JavaTokenType::SEMI_COLON,
		   JavaTokenType::QUESTION_MARK,
		   JavaTokenType::LESS_THAN,
		   JavaTokenType::GREATER_THAN,
		   JavaTokenType::DOT,
		   JavaTokenType::COMMA,

		   JavaTokenType::APOSTROPHE,
		   JavaTokenType::QUOTATION,
		   JavaTokenType::LEFT_PAREN,
		   JavaTokenType::RIGHT_PAREN,
		   JavaTokenType::LEFT_BRACKET,
		   JavaTokenType::RIGHT_BRACKET,
		   JavaTokenType::LEFT_BRACE,
		   JavaTokenType::RIGHT_BRACE,


           JavaTokenType::INCREMENT,
		   JavaTokenType::DECREMENT,
		   JavaTokenType::BIT_LEFT,
		   JavaTokenType::BIT_RIGHT,
		   JavaTokenType::LESS_EQUALS,
		   JavaTokenType::GREATER_EQUALS,
		   JavaTokenType::ADD_EQUALS,
		   JavaTokenType::MINUS_EQUALS,
		   JavaTokenType::MULT_EQUALS,
		   JavaTokenType::DIV_EQUALS,

           JavaTokenType::EQUALS_EQUALS,
		   JavaTokenType::OR_EQUALS,
		   JavaTokenType::REMAIN_EQUALS,
		   JavaTokenType::AND_EQUALS,
		   JavaTokenType::XOR_EQUALS,
		   JavaTokenType::NOT_EQUALS,
		   JavaTokenType::LSHIFT_EQUALS,
		   JavaTokenType::RSHIFT_EQUALS,
		   JavaTokenType::LOGIC_OR,
		   JavaTokenType::LOGIC_AND,

           JavaTokenType::LINE_COMMENT,
		   JavaTokenType::BEGIN_COMMENT,
		   JavaTokenType::END_COMMENT
    };

    for (int i = 0; i < ss_strings.size(); i++)
    {
        SPECIAL_SYMBOLS[ss_strings[i]] = ss_keys[i];
    }

    vector<string> ss_names =
    {
           "TILDE", "EXCLAMATION", "AT", "PERCENT", "HAT", "AMPERSAND", "MULT", "MINUS", "PLUS", "EQUALS",
           "BIT_OR", "SLASH", "COLON", "SEMI_COLON", "QUESTION_MARK", "LESS_THAN", "GREATER_THAN", "DOT", "COMMA",
           "APOSTROPHE", "QUOTATION", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_BRACE", "RIGHT_BRACE",
           "INCREMENT", "DECREMENT", "BIT_LEFT", "BIT_RIGHT", "LESS_EQUALS", "GREATER_EQUALS", "ADD_EQUALS", "MINUS_EQUALS", "MULT_EQUALS", "DIV_EQUALS",
           "EQUALS_EQUALS", "OR_EQUALS", "REMAIN_EQUALS", "AND_EQUALS", "XOR_EQUALS", "NOT_EQUALS", "LSHIFT_EQUALS", "RSHIFT_EQUALS", "LOGIC_OR", "LOGIC_AND",
           "LINE_COMMENT", "BEGIN_COMMENT", "END_COMMENT"
    };

    for (int i = 0; i < ss_names.size(); i++)
    {
        SPECIAL_SYMBOL_NAMES[ss_keys[i]] = ss_names[i];
    }

    INITIALIZED = true;
}

JavaToken::JavaToken(Source *source) throw (string)
    : Token(source)
{
    initialize();
}

}}}  // namespace wci::frontend::Java
