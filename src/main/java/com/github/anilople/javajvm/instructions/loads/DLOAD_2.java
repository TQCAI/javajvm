package com.github.anilople.javajvm.instructions.loads;

import com.github.anilople.javajvm.instructions.BytecodeReader;
import com.github.anilople.javajvm.instructions.Instruction;
import com.github.anilople.javajvm.runtimedataarea.Frame;

public class DLOAD_2 implements Instruction {

    @Override
    public void fetchOperands(BytecodeReader bytecodeReader) {

    }

    @Override
    public void execute(Frame frame) {
        DLOAD.execute(this, frame, 2);
    }

    @Override
    public int size() {
        return 1;
    }

}
