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
		   JavaTokenType::CARET,
		   JavaTokenType::AMPERSAND,
		   JavaTokenType::ASTERISK,
		   JavaTokenType::MINUS,
		   JavaTokenType::PLUS,
		   JavaTokenType::ASSIGN,

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
		   JavaTokenType::LEFT_BRACE,
		   JavaTokenType::RIGHT_BRACE,
		   JavaTokenType::LEFT_BRACKET,
		   JavaTokenType::RIGHT_BRACKET,

           JavaTokenType::INCREMENT,
		   JavaTokenType::DECREMENT,
		   JavaTokenType::BIT_LEFT,
		   JavaTokenType::BIT_RIGHT,
		   JavaTokenType::LESS_EQUALS,
		   JavaTokenType::GREATER_EQUALS,
		   JavaTokenType::ADD_ASSIGN,
		   JavaTokenType::MINUS_ASSIGN,
		   JavaTokenType::MULT_ASSIGN,
		   JavaTokenType::DIV_ASSIGN,

           JavaTokenType::EQUALS,
		   JavaTokenType::OR_ASSIGN,
		   JavaTokenType::REMAIN_ASSIGN,
		   JavaTokenType::AND_ASSIGN,
		   JavaTokenType::XOR_ASSIGN,
		   JavaTokenType::LEFT_SHIFT_ASSIGN,
		   JavaTokenType::RIGHT_SHIFT_ASSIGN,
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
           "TILDE", "EXCLAMATION", "AT", "PERCENT", "CARET", "AMPERSAND", "ASTERISK", "MINUS", "PLUS", "ASSIGN",
           "BIT_OR", "SLASH", "COLON", "SEMI_COLON", "QUESTION_MARK", "LESS_THAN", "GREATER_THAN", "DOT", "COMMA",
           "APOSTROPHE", "QUOTATION", "LEFT_PAREN", "RIGHT_PAREN", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACKET",
           "INCREMENT", "DECREMENT", "BIT_LEFT", "BIT_RIGHT", "LESS_EQUALS", "GREATER_EQUALS", "ADD_ASSIGN", "MINUS_ASSIGN", "MULT_ASSIGN", "DIV_ASSIGN",
           "EQUALS", "OR_ASSIGN", "REMAIN_ASSIGN", "AND_ASSIGN", "XOR_ASSIGN", "LEFT_SHIFT_ASSIGN", "RIGHT_SHIFT_ASSIGN", "LOGIC_OR", "LOGIC_AND",
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
