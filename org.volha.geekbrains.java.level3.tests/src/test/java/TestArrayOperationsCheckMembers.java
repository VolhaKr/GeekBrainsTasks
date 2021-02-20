import org.junit.*;

public class TestArrayOperationsCheckMembers {
    ArrayOperations arrayOperations;
    int[] intput;

    @Before
    public void prepare() {
        arrayOperations = new ArrayOperations();
    }

    @Test
    public void testArrayCheckMembersOnly1() {
        intput = new int[]{1, 1, 1};
        Assert.assertTrue(!arrayOperations.checkMembers(intput));
    }

    @Test
    public void testArrayCheckMembersOnly4() {
        intput = new int[]{4, 4, 4};
        Assert.assertTrue(!arrayOperations.checkMembers(intput));
    }

    @Test
    public void testArrayCheckMembers4AND1() {
        intput = new int[]{4, 4, 1, 4, 4, 1};
        Assert.assertTrue(arrayOperations.checkMembers(intput));
    }

    @Test
    public void testArrayCheckMembersOtherNumber() {
        intput = new int[]{4, 5, 4, 1, 4, 4, 1};
        Assert.assertTrue(!arrayOperations.checkMembers(intput));
    }

    @Test
    public void testArrayCheckMembersOnlyOtherNumber() {
        intput = new int[]{34, 5, 0, 8, 7, 45, 11};
        Assert.assertTrue(!arrayOperations.checkMembers(intput));
    }

}
