package org.bhanu;

import org.junit.*;
import static org.junit.Assert.*;

public class UserServiceTest {
	InteractCmpt i=new InteractCmpt();
    @Test
    public void testInteract() {
        String result = i.interact("Test Input");
        assertEquals("Processed: Test Input", result);
    }
}
