/*
Redline Smalltalk is licensed under the MIT License

Redline Smalltalk Copyright (c) 2010 James C. Ladd

Permission is hereby granted, free of charge, to any person obtaining a copy of this software
and associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package st.redline.smalltalk.interpreter;

import java.util.ArrayList;
import java.util.List;

public class LiteralArray extends Literal {

	private final List<Literal> literals;
	private int line;

	public LiteralArray() {
		super(null, 0);
		literals = new ArrayList<Literal>();
	}

	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	public void eachAccept(final NodeVisitor visitor) {
		for (Literal literal : literals)
			if (literal instanceof ArrayLiteral)
				visitor.visit((ArrayLiteral) literal);
			else if (literal instanceof LiteralArray)
				visitor.visit((LiteralArray) literal);
	}

	public void add(Literal literal) {
		literals.add(literal);
	}

	public void line(int line) {
		this.line = line;
	}

	public int line() {
		return line;
	}
}