package org.dalol.habeshamusic;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by filippo on 13/01/2018.
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void text_useAppContext() throws Exception {
        // Context of the app under test.
        Context context = InstrumentationRegistry.getTargetContext();
        assertEquals("org.dalol.habeshamusic", context.getPackageName());
    }
}
