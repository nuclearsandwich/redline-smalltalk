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

public class BinaryMessageSend extends BasicListNode {

	private final Primary primary;
	private final UnaryMessageSend unaryMessageSend;

	public BinaryMessageSend(Primary primary) {
		this.primary = primary;
		this.unaryMessageSend = null;
	}

	public BinaryMessageSend(UnaryMessageSend unaryMessageSend) {
		this.unaryMessageSend = unaryMessageSend;
		this.primary = null;
	}

	public void add(BinaryMessage binaryMessage) {
		super.add(binaryMessage);
	}

	public boolean isPrimary() {
		return primary != null;
	}

	public Primary primary() {
		return primary;
	}

	public boolean isUnaryMessageSend() {
		return unaryMessageSend != null;
	}

	public UnaryMessageSend unaryMessageSend() {
		return unaryMessageSend;
	}

	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	public void eachAccept(final NodeVisitor visitor) {
		each(new NodeCommand() {
			public void execute(Node node) {
				visitor.visit((BinaryMessage) node);
			}
		});
	}
}