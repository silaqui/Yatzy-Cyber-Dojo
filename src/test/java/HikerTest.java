import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class HikerTest {

    @Test
    public void life_the_universe_and_everything() {
        HikerHelper helper = mock(HikerHelper.class);
        Hiker douglas = new Hiker(helper);
        when(helper.multiplier()).thenReturn(9);
        assertEquals(54, douglas.answer());
        verify(helper,times(1)).multiplier();
    }
}
