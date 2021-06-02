package example;

import com.clarivate.woslite.ApiClient;
import com.clarivate.woslite.ApiException;
import com.clarivate.woslite.Configuration;
import com.clarivate.woslite.api.IntegrationApi;
import com.clarivate.woslite.auth.ApiKeyAuth;
import com.clarivate.woslite.models.WosLiteResponse;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.clarivate.com/api/woslite");

        // Configure API key authorization: key
        ApiKeyAuth key = (ApiKeyAuth) defaultClient.getAuthentication("key");
        key.setApiKey("YOUR API KEY");


        IntegrationApi apiInstance = new IntegrationApi(defaultClient);
        String databaseId = "WOS"; // String | Database to search. Must be a valid database ID, one of the following: BCI/BIOABS/BIOSIS/CCC/DCI/DIIDW/MEDLINE/WOK/WOS/ZOOREC. WOK represents all databases.
        String uniqueId = "WOS:000270372400005"; // String | Primary item(s) id to be searched, ex: WOS:000270372400005. Cannot be null or an empty string. Multiple values are separated by comma.
        Integer count = 10; // Integer | Number of records returned in the request
        Integer firstRecord = 1; // Integer | Specific record, if any within the result set to return. Cannot be less than 1 and greater than 100000.
        String lang = "en"; // String | Language of search. This element can take only one value: en for English. If no language is specified, English is passed by default.
        String sortField = ""; // String | Order by field(s). Field name and order by clause separated by '+', use A for ASC and D for DESC, ex: PY+D. Multiple values are separated by comma.
        try {
            WosLiteResponse result = apiInstance.idUniqueIdGet(databaseId, uniqueId, count, firstRecord, lang, sortField);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IntegrationApi#idUniqueIdGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}