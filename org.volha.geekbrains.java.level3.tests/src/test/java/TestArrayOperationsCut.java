import org.junit.*;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

public class TestArrayOperationsCut {
    ArrayOperations arrayOperations;
    int[] intput;
    int[] expectedOutput;

    @BeforeClass
    public static void init() {
        System.out.println("@BeforeClass");
    }

    @Before
    public void prepare() {
        arrayOperations = new ArrayOperations();
    }

    @After
    public void afterMethod() {
        System.out.println("@After");
    }

    @AfterClass
    public static void finish() {
        System.out.println("@AfterClass");
    }

    @Test
    public void testArrayCutReturnSubArr() {
        intput = new int[]{1, 44, 4, 5, 1, 1};
        expectedOutput = new int[]{5, 1, 1};
        Assert.assertEquals(
                Arrays.toString(expectedOutput),
                Arrays.toString(arrayOperations.arrayCut(intput)));
        //    ТАК И НЕ ПОНЯЛА, ПОЧЕМУ ЭТО НЕ ЗАРАБОТАЛО
        //    Assert.assertTrue(expectedOutput.equals(arrayOperations.arrayCut(intput)));
    }

    @Test
    public void testArrayCutSeveralCriticalsReturnSubArr() {
        intput = new int[]{4, 4, 4, 5, 1, 1};
        expectedOutput = new int[]{5, 1, 1};
        Assert.assertThat(expectedOutput, is(arrayOperations.arrayCut(intput)));
    }

    @Test
    public void testArrayCutStartsWithCriticalReturnSubArr() {
        intput = new int[]{4, 5, 1, 1};
        expectedOutput = new int[]{5, 1, 1};
        Assert.assertThat(expectedOutput, is(arrayOperations.arrayCut(intput)));
    }

    @Test(expected = RuntimeException.class)
    public void testArrayEmptyThrowRuntime() {
        intput = new int[]{44, 444, 4444, 414};
        arrayOperations.arrayCut(intput);

    }
}
