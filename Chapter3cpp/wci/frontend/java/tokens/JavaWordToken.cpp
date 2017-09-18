/**
 * <h1>JavaWordToken</h1>
 *
 * <p> Java word tokens (identifiers and reserved words).</p>
 *
 * <p>Copyright (c) 2017 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
#include <iostream>
#include <string>
#include <map>
#include <algorithm>
#include "JavaWordToken.h"
#include "../JavaError.h"

namespace wci { namespace frontend { namespace java { namespace tokens {

using namespace std;
using namespace wci::frontend;
using namespace wci::frontend::java;

JavaWordToken::JavaWordToken(Source *source) throw (string)
    : JavaToken(source)
{
    extract();
}

/**
 * Extract a Java word token from the source.
 * @throws Exception if an error occurred.
 */
void JavaWordToken::extract() throw (string)
{
    char current_ch = current_char();

    // Get the word characters (letter or digit). The scanner has
    // already determined that the first character is a letter.
    while (isalnum(current_ch))
    {
        text += current_ch;
        current_ch = next_char();  // consume character
    }

    // Is it a reserved word or an identifier?
    string upper_case(text);

    int capital_letters = 0;

    for(char c : upper_case)
    {
    	if(isupper(c))
    		++capital_letters;
    }

    if (capital_letters == 0) {
	   //transform(upper_case.begin(), upper_case.end(), upper_case.begin(), ::toupper);
    	for(int i = 0; i < upper_case.size();i++)
    	{
    		upper_case.at(i) = toupper(upper_case.at(i));
    	}
		if (JavaToken::RESERVED_WORDS.find(upper_case)
				!= JavaToken::RESERVED_WORDS.end())
		{
			// Reserved word.
			type = (TokenType) JavaToken::RESERVED_WORDS[upper_case];
			value = new DataValue(upper_case);
		}
	    else
	    {
	        // Identifier.
	        type = (TokenType) PT_IDENTIFIER;
	    }
    }
    else if(current_ch >= 'A' || current_ch <='Z' || current_ch >= 'a' || current_ch <= 'z' || current_ch == '_')
		{
			// Identifier.
			type = (TokenType) PT_IDENTIFIER;
		}
}

}}}}   // namespace wci::frontend::java::tokens
