import org.apache.commons.httpclient.HttpClient
import org.apache.commons.httpclient.methods.GetMethod
import java.io.File

fun main(args: Array<String>) {
    var client = HttpClient()
//    var range = 1..15
//    for (i in range) {
    var method = GetMethod("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1575484544234&di=cc9c80660ead35a21dfb651e2627e3dd&imgtype=0&src=http%3A%2F%2Fdesk-fd.zol-img.com.cn%2Ft_s960x600c5%2Fg4%2FM04%2F04%2F03%2FCg-4WVQSY5GIXCJfAAgcMfHEIBEAARXwQHY7j8ACBxJ524.jpg")
    client.executeMethod(method)
    var result = method.getResponseBody()
    method.releaseConnection()
    var file = File("2.jpg")
    file.writeBytes(result)
//    }
}