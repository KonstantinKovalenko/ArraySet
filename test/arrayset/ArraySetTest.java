package arrayset;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import static mytoys.Print.println;

public class ArraySetTest {

    public ArraySetTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testToString() {
        ArraySet arraySet = new ArraySet();
        println("arraySet.toString = " + arraySet.toString());
    }

    @Test
    public void testSize() {
        ArraySet arraySet = new ArraySet();
        int expected = 10;
        for (int i = 0; i < 10; i++) {
            arraySet.add(i);
        }
        assertEquals(expected, arraySet.size());
    }

    @Test
    public void testIsEmptyTrue() {
        ArraySet arraySet = new ArraySet();
        for (int i = 0; i < 10; i++) {
            arraySet.add("" + i);
        }
        assertFalse(arraySet.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        ArraySet arraySet = new ArraySet();
        assertTrue(arraySet.isEmpty());
    }

    @Test
    public void testContains() {
        ArraySet<Integer> arraySet = new ArraySet();
        for (int i = 0; i < 10; i++) {
            arraySet.add(i);
        }
        Integer workInt = 5;
        assertTrue(arraySet.contains(workInt));
    }

    @Test
    public void testDontContains() {
        ArraySet<Integer> arraySet = new ArraySet();
        for (int i = 0; i < 10; i++) {
            arraySet.add(i);
        }
        Integer workInt = 15;
        assertFalse(arraySet.contains(workInt));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsNull() {
        ArraySet arraySet = new ArraySet();
        assertTrue(arraySet.contains(null));
    }

    @Test(expected = ClassCastException.class)
    public void testContainsWrongClass() {
        ArraySet<Integer> arraySet = new ArraySet();
        for (int i = 0; i < 10; i++) {
            arraySet.add(i);
        }
        String workString = "someString";
        arraySet.contains(workString);
    }

    @Test
    public void testIterator() {
        ArraySet<Integer> arraySet = new ArraySet();
        Iterator it = arraySet.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        assertTrue(arraySet.size() == 0);
    }

    @Test
    public void testToArray_0args() {
        ArraySet<Integer> arraySet = new ArraySet();
        Object[] intArray = arraySet.toArray();
        assertTrue(intArray.length == arraySet.size());
    }

    @Test
    public void testToArray_ObjectArr() {
        ArraySet<Integer> arraySet = new ArraySet();
        for (int i = 0; i < 5; i++) {
            arraySet.add(i);
        }
        int expected = 15;
        Object[] parameterArray = new Integer[15];
        for (int i = 0; i < 15; i++) {
            parameterArray[i] = i;
        }
        Object[] resultArray = arraySet.toArray(parameterArray);
        println("\t\t\ttestToArray_ObjectArr started"
                + "\narraySet = " + arraySet.toString()
                + "\nparameterArray = " + Arrays.toString(parameterArray)
                + "\nObject[] resultArray = arraySet.toArray(parameterArray) : " + Arrays.toString(resultArray)
                + "\n\t\t\ttestToArray_ObjectArr ended");
        assertTrue(resultArray.length == 15);
    }

    @Test(expected = NullPointerException.class)
    public void testToArray_ObjectArrNull() {
        ArraySet<Integer> arraySet = new ArraySet();
        arraySet.toArray(null);
    }

    @Test
    public void testAdd() {
        ArraySet arraySet = new ArraySet<>();
        assertTrue(arraySet.add(1));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        ArraySet arraySet = new ArraySet<>();
        arraySet.add(null);
    }

    @Test(expected = ClassCastException.class)
    public void testAddWrongClass() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        String workString = "someString";
        arraySet.add(workString);
        println(arraySet);
    }

    @Test
    public void testRemove() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        for (int i = 0; i < 5; i++) {
            arraySet.add(i);
        }
        ArraySet<Integer> expected = new ArraySet();
        for (int i = 0; i < 3; i++) {
            expected.add(i);
        }
        arraySet.remove(3);
        arraySet.remove(4);
        assertEquals(expected.toString(), arraySet.toString());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNull() {
        ArraySet arraySet = new ArraySet<>();
        arraySet.add("");
        arraySet.remove(null);
    }

    @Test(expected = ClassCastException.class)
    public void testRemoveWrongClass() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        arraySet.add(1);
        String workString = "someString";
        arraySet.remove(workString);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveOutOfBounds() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        arraySet.remove(1);
    }

    @Test
    public void testContainsAll() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        for (int i = 0; i < 50; i++) {
            arraySet.add(i);
        }
        Collection testCollection = new LinkedList();
        for (int i = 6; i < 43; i++) {
            testCollection.add(i);
        }
        assertTrue(arraySet.containsAll(testCollection));
    }

    @Test
    public void testDontContainsAll() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        for (int i = 0; i < 50; i++) {
            arraySet.add(i);
        }
        Collection testCollection = new LinkedList();
        for (int i = 30; i < 80; i++) {
            testCollection.add(i);
        }
        assertFalse(arraySet.containsAll(testCollection));
    }

    @Test(expected = NullPointerException.class)
    public void testContainsAllNull() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        arraySet.containsAll(null);
    }

    @Test(expected = ClassCastException.class)
    public void testContainsAllWrongClass() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        arraySet.add(1);
        Collection testCollection = new LinkedList();
        testCollection.add("someString");
        arraySet.containsAll(testCollection);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testContainsAllOutOfBounds() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        Collection testCollection = new ArrayList();
        arraySet.containsAll(testCollection);
    }

    @Test
    public void testAddAll() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        for (int i = 0; i < 10; i++) {
            arraySet.add(i);
        }
        Object[] saved = arraySet.toArray();
        Collection<Integer> testCollection = new LinkedList();
        for (int i = 0; i < 51; i++) {
            if (i % 10 == 0) {
                testCollection.add(i);
            }
        }
        ArraySet<Integer> expected = new ArraySet<>();
        for (int i = 0; i < 51; i++) {
            if (i < 10) {
                expected.add(i);
            }
            if (i % 10 == 0) {
                expected.add(i);
            }
        }
        arraySet.addAll(testCollection);
        println("\t\t\ttestAddAll started"
                + "\narraySet = " + Arrays.toString(saved)
                + "\ntestCollection = " + testCollection.toString()
                + "\narraySet.addAll(testCollection) = " + arraySet.toString()
                + "\n\t\t\ttestAddAll ended");
        assertEquals(arraySet.toString(), expected.toString());
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllNull() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        arraySet.add(1);
        arraySet.addAll(null);
    }

    @Test(expected = ClassCastException.class)
    public void testAddAllWrongClass() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        arraySet.add(1);
        Collection testCollection = new LinkedList();
        testCollection.add("someString");
        arraySet.addAll(testCollection);
    }

    @Test
    public void testRetainAll() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        for (int i = 0; i < 10; i++) {
            arraySet.add(i);
        }
        Object[] saved = arraySet.toArray();
        Collection<Integer> testCollection = new LinkedList();
        for (int i = 5; i < 15; i++) {
            testCollection.add(i);
        }
        ArraySet<Integer> expected = new ArraySet<>();
        for (int i = 5; i < 10; i++) {
            expected.add(i);
        }
        arraySet.retainAll(testCollection);
        println("\t\t\ttestRetainAll started"
                + "\narraySet = " + Arrays.toString(saved)
                + "\ntestCollection = " + testCollection.toString()
                + "\narraySet.retainAll(testCollection) = " + arraySet.toString()
                + "\n\t\t\ttestRetainAll ended");
        assertEquals(arraySet.toString(), expected.toString());
    }

    @Test
    public void testRetainAllNoMatches() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        for (int i = 0; i < 10; i++) {
            arraySet.add(i);
        }
        Object[] saved = arraySet.toArray();
        Collection<Integer> testCollection = new LinkedList();
        for (int i = 10; i < 15; i++) {
            testCollection.add(i);
        }
        ArraySet<Integer> expected = new ArraySet<>();
        arraySet.retainAll(testCollection);
        println("\t\t\ttestRetainAllNoMatches started"
                + "\narraySet = " + Arrays.toString(saved)
                + "\ntestCollection = " + testCollection.toString()
                + "\narraySet.retainAll(testCollection) = " + arraySet.toString()
                + "\n\t\t\ttestRetainAllNoMatches ended");
        assertEquals(arraySet.toString(), expected.toString());
    }

    @Test(expected = NullPointerException.class)
    public void testRetainAllNull() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        arraySet.add(1);
        arraySet.retainAll(null);
    }

    @Test(expected = ClassCastException.class)
    public void testRetainAllWrongClass() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        arraySet.add(1);
        Collection testCollection = new LinkedList();
        testCollection.add("someString");
        arraySet.retainAll(testCollection);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRetainAllOutOfBounds() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        Collection testCollection = new ArrayList();
        arraySet.retainAll(testCollection);
    }

    @Test
    public void testRemoveAll() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        for (int i = 0; i < 10; i++) {
            arraySet.add(i);
        }
        Object[] saved = arraySet.toArray();
        Collection testCollection = new ArrayList();
        for (int i = 3; i < 7; i++) {
            testCollection.add(i);
        }
        ArraySet<Integer> expected = new ArraySet<>();
        for (int i = 0; i < 10; i++) {
            if (i < 3 || i > 6) {
                expected.add(i);
            }
        }
        arraySet.removeAll(testCollection);
        println("\t\t\ttestremoveAll started"
                + "\narraySet = " + Arrays.toString(saved)
                + "\ntestCollection = " + testCollection.toString()
                + "\narraySet.removeAll(testCollection) = " + arraySet.toString()
                + "\n\t\t\ttestremoveAll ended");
        assertEquals(arraySet.toString(), expected.toString());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveAllNull() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        arraySet.removeAll(null);
    }

    @Test(expected = ClassCastException.class)
    public void testRemoveAllWrongClass() {
        ArraySet<Integer> arraySet = new ArraySet<>();
        arraySet.add(1);
        Collection testCollection = new LinkedList();
        testCollection.add("someString");
        arraySet.removeAll(testCollection);
    }

    @Test
    public void testClear() {
        ArraySet arraySet = new ArraySet<>();
        arraySet.add(1);
        arraySet.clear();
        assertTrue(arraySet.isEmpty());
    }

}
