package cn.tj.fnzi;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;

public class CamelHandler {

	@Autowired
	ProducerTemplate camelTemplate;

	public void handler(Exchange exchange) {

		SAXReader saxReader = new SAXReader();
		Document document = null;

		try {
			document = saxReader.read(new ByteArrayInputStream(exchange.getIn()
					.getBody().toString().getBytes("UTF-8")));

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String enb = document.selectSingleNode("//R/BD/ENB").getText();

		Map<String, String> ret = new HashMap<String, String>();
		ret.put("enb", enb);

		camelTemplate.sendBody("direct-vm:continue", ret);
	}
}
