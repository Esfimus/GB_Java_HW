package lesson14;

import org.junit.Assert;
import org.junit.Test;

public class TestValues {

    HW14 object = new HW14();

    @Test
    public void arrayTest1() {
        Assert.assertArrayEquals(new int[]{3, 5, 7}, object.after4(new int[]{8, 2, 4, 3, 5, 7}));
        Assert.assertArrayEquals(new int[]{7}, object.after4(new int[]{8, 2, 4, 3, 4, 7}));
        Assert.assertArrayEquals(new int[]{1, 3, 5, 7}, object.after4(new int[]{4, 4, 1, 3, 5, 7}));
        Assert.assertArrayEquals(new int[]{}, object.after4(new int[]{4, 4, 4}));
        Assert.assertThrows(RuntimeException.class, () -> object.after4(new int[]{9, 2, 1, 3, 5, 7}));
    }

    @Test
    public void arrayTest2() {
        Assert.assertTrue(object.check1and4(new int[]{1, 4, 1, 4, 4, 1, 4, 4}));
        Assert.assertFalse(object.check1and4(new int[]{1, 1, 1, 1, 1}));
        Assert.assertFalse(object.check1and4(new int[]{4, 4}));
        Assert.assertFalse(object.check1and4(new int[]{4, 1, 4, 1 , 2}));
    }
}