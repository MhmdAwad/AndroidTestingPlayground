package com.mhmdawad.unittestingplayground

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test


class ResourceComparatorTest{


    private lateinit var resourceComparator: ResourceComparator
    private lateinit var context: Context
    @Before
    fun setup(){
        resourceComparator = ResourceComparator()
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun stringValueGivenTheSameResIntValue_returnsTrue(){
        val result = resourceComparator.isEqual(
            context,
            R.string.app_name,
            "UnitTestingPlayground"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun stringValueGivenDifferentResIntValue_returnsFalse(){
        val result = resourceComparator.isEqual(
            context,
            R.string.app_name,
            "UnitTesting"
        )
        assertThat(result).isFalse()
    }
}