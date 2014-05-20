package jp.co.foo;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.Client;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;

public class EsClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node node = nodeBuilder().node();
		Client client = node.client();
		BulkRequestBuilder bulkRequest = client.prepareBulk();
        
		client.prepareIndex("testindex", "article")
        .setSource(putJsonDocument("Example Title",
                                   "This description is so important. You dont even know!",
                                   new Date(),
                                   "J.R."))
                                   .execute().actionGet();

        node.close();
	}
	
	
	public static Map<String, Object> putJsonDocument(String title,
			String content, Date postDate, String author) {

		Map<String, Object> jsonDocument = new HashMap<String, Object>();

		jsonDocument.put("title", title);
		jsonDocument.put("conten", content);
		jsonDocument.put("postDate", postDate);
		jsonDocument.put("author", author);

		return jsonDocument;
	}

}
