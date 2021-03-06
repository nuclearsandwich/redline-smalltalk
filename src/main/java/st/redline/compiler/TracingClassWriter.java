/* Redline Smalltalk, Copyright (c) James C. Ladd. All rights reserved. See LICENSE in the root of this distribution */
package st.redline.compiler;

import java.io.PrintWriter;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

public class TracingClassWriter extends ClassWriter {

    private final PrintWriter out;

    public TracingClassWriter(int computeMaxs, PrintWriter printWriter) {
        super(computeMaxs);
        this.out = printWriter;
    }

    public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {
        out.println("");
        out.println("  visit(" + i + ", " + i1 + ", '" + s + "', '" + s1 + "', '" + s2 + "', " + strings + ")");
        super.visit(i, i1, s, s1, s2, strings);
    }

    public void visitSource(String s, String s1) {
        out.println("  visitSource('" + s + "', '" + s1 + "')");
        super.visitSource(s, s1);
    }

    public void visitOuterClass(String s, String s1, String s2) {
        out.println("  visitOuterClass('" + s + "', '" + s1 + "', '" + s2 + "')");
        super.visitOuterClass(s, s1, s2);
    }

    public AnnotationVisitor visitAnnotation(String s, boolean b) {
        out.println("  visitAnnotation('" + s + "', " + b + ")");
        return super.visitAnnotation(s, b);
    }

    public void visitAttribute(Attribute attribute) {
        out.println("  visitAttribute(" + attribute + ")");
        super.visitAttribute(attribute);
    }

    public void visitInnerClass(String s, String s1, String s2, int i) {
        out.println("  visitInnerClass('" + s + "', '" + s1 + "', '" + s2 + "', " + i + ")");
        super.visitInnerClass(s, s1, s2, i);
    }

    public FieldVisitor visitField(int i, String s, String s1, String s2, Object o) {
        out.println("  visitField(" + i + ", '" + s + "', '" + s1 + "', '" + s2 + "', " + o + ")");
        return super.visitField(i, s, s1, s2, o);
    }

    public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
        out.println("\n  visitMethod(" + i + ", '" + s + "', '" + s1 + "', '" + s2 + "', " + strings + ")");
        return new TracingMethodVisitor(super.visitMethod(i, s, s1, s2, strings));
    }

    public void visitEnd() {
        out.println("  visitEnd()\n");
        super.visitEnd();
    }
}