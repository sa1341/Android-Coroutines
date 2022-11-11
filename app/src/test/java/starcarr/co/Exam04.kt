package starcarr.co

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import org.w3c.dom.Element
import org.w3c.dom.Node
import javax.xml.parsers.DocumentBuilderFactory

private val newDispatcher = newSingleThreadContext(name = "ServiceCall")
private val factory = DocumentBuilderFactory.newInstance()

fun main() {
    println("TEST")
    val headlines = fetchRssHeadlines()
    GlobalScope.launch(newDispatcher) {
        val headlines = fetchRssHeadlines()
        headlines.forEach {
            println("headeline = $it")
        }
    }
}

private fun fetchRssHeadlines(): List<String> {
    val builder = factory.newDocumentBuilder()
    val xml = builder.parse("https://www.npr.org/rss/rss.php?id=1001")
    println("xml = $xml")
    val news = xml.getElementsByTagName("channel").item(0)
    return (0 until news.childNodes.length)
        .map { news.childNodes.item(it) }
        .filter { Node.ELEMENT_NODE == it.nodeType }
        .map { it as Element }
        .filter { "item" == it.tagName }
        .map {
            it.getElementsByTagName("title").item(0).textContent
        }
}

