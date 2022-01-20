package com.github.pjfanning.java.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExceptionUtilTest {
    @Test
    void testRuntimeException() {
        assertFalse(ExceptionUtil.isFatal(new RuntimeException("runtime issue")));
    }

    @Test
    void testPlainException() {
        assertFalse(ExceptionUtil.isFatal(new Exception("plain issue")));
    }

    @Test
    void testOutOfMemoryError() {
        assertTrue(ExceptionUtil.isFatal(new OutOfMemoryError("oom")));
    }

    @Test
    void testVirtualMachineError() {
        assertTrue(ExceptionUtil.isFatal(new VirtualMachineError(){}));
    }


    @Test
    void testThreadDeath() {
        assertTrue(ExceptionUtil.isFatal(new ThreadDeath()));
    }

    @Test
    void testInterruptedException() {
        assertTrue(ExceptionUtil.isFatal(new InterruptedException()));
    }

    @Test
    void testLinkageError() {
        assertTrue(ExceptionUtil.isFatal(new LinkageError()));
    }
}
