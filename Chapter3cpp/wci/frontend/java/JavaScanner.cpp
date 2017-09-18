/**
 * <h1>JavaScanner</h1>
 *
 * <p>The Java scanner.</p>
 *
 * <p>Copyright (c) 2017 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
#include <iostream>
#include "JavaScanner.h"
#include "JavaToken.h"
#include "JavaError.h"
#include "../Source.h"
#include "tokens/JavaWordToken.h"
#include "tokens/JavaNumberToken.h"
#include "tokens/JavaStringToken.h"
#include "tokens/JavaSpecialSymbolToken.h"
#include "tokens/JavaErrorToken.h"

namespace wci { namespace frontend { namespace java {

using namespace std;
using namespace wci::frontend;
using namespace wci::frontend::java::tokens;

JavaScanner::JavaScanner(Source *source) : Scanner(source)
{
}

Token *JavaScanner::extract_token() throw (string)
{
    skip_white_space();

    Token *token;
    char current_ch = current_char();
    string string_ch = " ";

    string_ch[0] = current_ch;

    // Construct the next token.  The current character determines the
    // token type.
    if (current_ch == Source::END_OF_FILE)
    {
        token = nullptr;
    }
    else if (isalpha(current_ch))
    {
        token = new JavaWordToken(source);
    }
    else if (isdigit(current_ch))
    {
       token = new JavaNumberToken(source);
    }
    else if (current_ch == '\'')
    {
       token = new JavaStringToken(source);
    }
    else if (JavaToken::SPECIAL_SYMBOLS.find(string_ch) != JavaToken::SPECIAL_SYMBOLS.end())
    {
        token = new JavaSpecialSymbolToken(source);
    }
    else
    {
        token = new JavaErrorToken(source, INVALID_CHARACTER, string_ch);
        next_char();  // consume character
    }

    return token;
}

void JavaScanner::skip_white_space() throw (string)
{
    char current_ch = current_char();

    //Searching For // or /* Type Comment
    while (isspace(current_ch) || (current_ch == '/')) {
    	if (current_ch == '/')
    	{
    		//Sets comment block checker to false
    	    bool end_block = false;
    		current_ch = next_char();
    		if (current_ch == '/')
    		{
    			do
				{
    				current_ch = next_char();  //Consumes all character in the rest of the line

				} while ((current_ch != Source::END_OF_LINE) &&
						 (current_ch != Source::END_OF_FILE));
    		}

    		if (current_ch == '*')
			{
				do
				{
					//previous_ch = current_ch;
					current_ch = next_char();  // consume comment characters
					if(current_ch == '*')
					{
						current_ch = next_char();
						if(current_ch == '/')
						{
							//set comment checker block to true to leave loop
							end_block = true;
						}
					}

				// while ((end_block != true) && (current_ch != Source::END_OF_FILE));
				} while ((end_block != true));

	            // Found closing '/'?
	            if (current_ch == '/')
	            {
	                current_ch = next_char();  // consume the '}'
	            }
			}

    	}

        else current_ch = next_char();  // consume whitespace character
    }
}


}}} // namespace wci::frontend::java
