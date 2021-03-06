package br.com.infoglobo

import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import br.com.infoglobo.data.model.News
import br.com.infoglobo.data.model.Section
import br.com.infoglobo.presentation.activity.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailsFragmentTest {

    @Rule
    @JvmField
    val activityScenario : ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    private val section = Section(
        name = "Brasil",
        url = "http://m.oglobo.globo.com/brasil/"
    )

    private val news = News(
        authors = arrayListOf(),
        publicityReport = false,
        subtitle = "subtitle",
        text = "text",
        updated = "2017-03-08T13:25:03-0300",
        id = 21030945,
        publishedIn = "2017-03-08T12:52:43-0300",
        section = section,
        type = "materia",
        title = "title",
        url = "http://m.oglobo.globo.com/brasil/sergio-cabral-denunciado-pela-sexta-vez-na-lava-jato-21030945",
        originalUrl = "http://m.oglobo.globo.com/brasil/sergio-cabral-denunciado-pela-sexta-vez-na-lava-jato-21030945",
        images = arrayListOf()
    )

    @Before
    fun goToDetailFragment() {
        activityScenario.scenario.onActivity { activity ->
            UiThreadStatement.runOnUiThread {
                val bundle = bundleOf("news" to news)
                val navHostFragment =
                    activity.supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
                navHostFragment.navController.navigate(R.id.home_to_details, bundle)
            }
        }
    }

    @Test
    fun shouldShowActionSend_WhenMenuItemClicked(){
        Intents.init()
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)
        onView(withText(R.string.share))
            .perform(click())
        Intents.release()
    }
}