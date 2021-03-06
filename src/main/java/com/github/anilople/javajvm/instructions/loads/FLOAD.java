package com.github.anilople.javajvm.instructions.loads;

import com.github.anilople.javajvm.instructions.BytecodeReader;
import com.github.anilople.javajvm.instructions.Instruction;
import com.github.anilople.javajvm.runtimedataarea.Frame;
import com.github.anilople.javajvm.utils.PrimitiveTypeUtils;

/**
 * Operation
 * Load float from local variable
 *
 * Operand ... →
 * Stack ..., value
 *
 * Description
 * The index is an unsigned byte that must be an index into the local
 * variable array of the current frame (§2.6). The local variable at
 * index must contain a float . The value of the local variable at index
 * is pushed onto the operand stack.
 *
 * Notes
 * The fload opcode can be used in conjunction with the wide
 * instruction (§wide) to access a local variable using a two-byte
 * unsigned index.
 */
public class FLOAD implements Instruction {

    private byte byteIndex;

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {
        this.byteIndex = bytecodeReader.readU1();
    }

    @Override
    public void execute(Frame frame) {
        FLOAD.execute(this, frame, resolveIndex());
    }

    @Override
    public int size() {
        return 2;
    }

    public static void execute(Instruction instruction, Frame frame, int index) {
        float value = frame.getLocalVariables().getFloatValue(index);
        frame.getOperandStacks().pushFloatValue(value);
        int nextPc = frame.getNextPc() + instruction.size();
        frame.setNextPc(nextPc);
    }

    public int resolveIndex() {
        return PrimitiveTypeUtils.intFormUnsignedByte(byteIndex);
    }

}
