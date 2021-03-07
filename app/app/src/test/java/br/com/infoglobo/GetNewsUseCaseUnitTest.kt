package br.com.infoglobo
import br.com.infoglobo.data.model.Content
import br.com.infoglobo.domain.ContentResult
import br.com.infoglobo.domain.repository.NewsRepository
import br.com.infoglobo.domain.usecase.GetNewsUseCase
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetNewsUseCaseUnitTest {

    private lateinit var useCase : GetNewsUseCase
    @Mock lateinit var repository: NewsRepository

    @Before
    fun setUp(){
        useCase = GetNewsUseCase(repository)
    }

    @Test
    fun `returns the loading result when loading retrieving the news`() {
        given(repository.getNews()).willReturn(Single.just(mock()))
        useCase.execute().test().assertValueAt(0) { (it == ContentResult.Loading) }
    }

    @Test
    fun `returns the success result when success retrieving the news`() {
        val content = mock<ArrayList<Content>>()
        given(repository.getNews()).willReturn(Single.just(content))
        useCase.execute().test().assertValueAt(1) { (it as ContentResult.Success).content == content }
    }

    @Test
    fun `returns the failure result when error retrieving the news`() {
        val throwable = Throwable()
        given(repository.getNews()).willReturn(Single.error(throwable))
        useCase.execute().test().assertValueAt(1) { (it as ContentResult.Failure).throwable == throwable }
    }
}