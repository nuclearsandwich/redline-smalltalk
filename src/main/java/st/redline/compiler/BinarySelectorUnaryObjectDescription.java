/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution */
package st.redline.compiler;

public class BinarySelectorUnaryObjectDescription {

    private final BinarySelector binarySelector;
    private final UnaryObjectDescription unaryObjectDescription;

    BinarySelectorUnaryObjectDescription(BinarySelector binarySelector, UnaryObjectDescription unaryObjectDescription) {
        this.binarySelector = binarySelector;
        this.unaryObjectDescription = unaryObjectDescription;
    }

    BinarySelector binarySelector() {
        return binarySelector;
    }

    UnaryObjectDescription unaryObjectDescription() {
        return unaryObjectDescription;
    }

    public void accept(NodeVisitor nodeVisitor) {
        if (unaryObjectDescription != null)
            unaryObjectDescription.accept(nodeVisitor);
        if (binarySelector != null)
            binarySelector.accept(nodeVisitor);
    }

    boolean hasBlockWithAnswerExpression() {
        return (unaryObjectDescription != null && unaryObjectDescription.hasBlockWithAnswerExpression());
    }
}
