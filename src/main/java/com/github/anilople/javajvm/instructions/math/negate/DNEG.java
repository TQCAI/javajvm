package com.github.anilople.javajvm.instructions.math.negate;

import com.github.anilople.javajvm.instructions.BytecodeReader;
import com.github.anilople.javajvm.instructions.Instruction;
import com.github.anilople.javajvm.runtimedataarea.Frame;

/**
 * Operation
 * Negate double
 *
 * Operand ..., value →
 * Stack ..., result
 *
 */
public class DNEG implements Instruction {

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {

    }

    @Override
    public void execute(Frame frame) {
        double value = frame.getOperandStacks().popDoubleValue();
        double result = - value;
        frame.getOperandStacks().pushDoubleValue(result);
        int nextPc = frame.getNextPc() + this.size();
        frame.setNextPc(nextPc);
    }

    @Override
    public int size() {
        return 1;
    }

}
