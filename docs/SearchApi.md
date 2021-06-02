# SearchApi

All URIs are relative to *https://api.clarivate.com/api/woslite*

Method | HTTP request | Description
------------- | ------------- | -------------
[**queryQueryIdGet**](SearchApi.md#queryQueryIdGet) | **GET** /query/{queryId} | Fetch record(s) by query identifier
[**rootGet**](SearchApi.md#rootGet) | **GET** / | Submits a user query and returns results


<a name="queryQueryIdGet"></a>
# **queryQueryIdGet**
> WosLiteResponse queryQueryIdGet(queryId, count, firstRecord, sortField)

Fetch record(s) by query identifier

This operation returns record(s) identified by a query identifier.

### Example

```java
// Import classes:

import com.clarivate.woslite.ApiClient;
import com.clarivate.woslite.ApiException;
import com.clarivate.woslite.Configuration;
import com.clarivate.woslite.api.SearchApi;
import com.clarivate.woslite.auth.ApiKeyAuth;
import com.clarivate.woslite.models.WosLiteResponse;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.clarivate.com/api/woslite");

        // Configure API key authorization: key
        ApiKeyAuth key = (ApiKeyAuth) defaultClient.getAuthentication("key");
        key.setApiKey("YOUR API KEY");


        SearchApi apiInstance = new SearchApi(defaultClient);
        Integer queryId = 56; // Integer | Retrieve records based on query identifier.
        Integer count = 56; // Integer | Number of records to return, must be 0-100.
        Integer firstRecord = 56; // Integer | Specific record, if any within the result set to return. Cannot be less than 1 and greater than 100000.
        String sortField = "sortField_example"; // String | Order by field(s). Field name and order by clause separated by '+', use A for ASC and D for DESC, ex: PY+D. Multiple values are separated by comma. If sortField was set on the original query, this parameter should be set as sorting is not a property of the query.
        try {
            WosLiteResponse result = apiInstance.queryQueryIdGet(queryId, count, firstRecord, sortField);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SearchApi#queryQueryIdGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **queryId** | **Integer**| Retrieve records based on query identifier. |
 **count** | **Integer**| Number of records to return, must be 0-100. |
 **firstRecord** | **Integer**| Specific record, if any within the result set to return. Cannot be less than 1 and greater than 100000. |
 **sortField** | **String**| Order by field(s). Field name and order by clause separated by &#39;+&#39;, use A for ASC and D for DESC, ex: PY+D. Multiple values are separated by comma. If sortField was set on the original query, this parameter should be set as sorting is not a property of the query. | [optional]

### Return type

[**WosLiteResponse**](WosLiteResponse.md)

### Authorization

[key](../README.md#key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  * X-RateLimit-Remaining-second - The number of requests left for the second window. <br>  * X-RateLimit-Limit-second - The number of requests limit per second. <br>  * x-paginate-by-query-id - The url of the next page in case your &#x60;RecordsFound &gt; count + firstRecord&#x60; Please use this url for pagination. The QueryId will live for four hours in case if inactivity.  <br>  |
**0** | Error response 400+ |  * X-RateLimit-Remaining-second - The number of requests left for the second window. <br>  * X-RateLimit-Limit-second - The number of requests limit per second. <br>  |

<a name="rootGet"></a>
# **rootGet**
> WosLiteResponse rootGet(databaseId, usrQuery, count, firstRecord, lang, edition, publishTimeSpan, loadTimeSpan, sortField)

Submits a user query and returns results

The search operation submits a search query to the specified database edition and retrieves data. This operation returns a query ID that can be used in subsequent operations to retrieve more records.

### Example

```java
// Import classes:

import com.clarivate.woslite.ApiClient;
import com.clarivate.woslite.ApiException;
import com.clarivate.woslite.Configuration;
import com.clarivate.woslite.api.SearchApi;
import com.clarivate.woslite.auth.ApiKeyAuth;
import com.clarivate.woslite.models.WosLiteResponse;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.clarivate.com/api/woslite");

        // Configure API key authorization: key
        ApiKeyAuth key = (ApiKeyAuth) defaultClient.getAuthentication("key");
        key.setApiKey("YOUR API KEY");


        SearchApi apiInstance = new SearchApi(defaultClient);
        String databaseId = "databaseId_example"; // String | Database to search. Must be a valid database ID, one of the following: BCI/BIOABS/BIOSIS/CCC/DCI/DIIDW/MEDLINE/WOK/WOS/ZOOREC. WOK represents all databases.
        String usrQuery = "usrQuery_example"; // String | User query for requesting data, ex: TS=(cadmium). The query parser will return errors for invalid queries.
        Integer count = 56; // Integer | Number of records to return, must be 0-100.
        Integer firstRecord = 56; // Integer | Specific record, if any within the result set to return. Cannot be less than 1 and greater than 100000.
        String lang = "lang_example"; // String | Language of search. This element can take only one value: en for English. If no language is specified, English is passed by default.
        String edition = "edition_example"; // String | Edition(s) to be searched. If null, user permissions will be substituted. Must include the name of the collection and edition name separated by '+', ex: WOS+SCI. Multiple editions are separated by ','. Editions available for collection(WOS) - AHCI,CCR,IC,ISSHP,ISTP,SCI,SSCI,BHCI,BSCI and ESCI.
        String publishTimeSpan = "publishTimeSpan_example"; // String | This element specifies a range of publication dates. If publishTimeSpan is used, the loadTimeSpan parameter must be omitted. If publishTimeSpan and loadTimeSpan are both omitted, then the maximum time span will be inferred from the editions data. Beginning and end dates should be specified in the yyyy-mm-dd format separated by +, ex: 1993-01-01+2009-12-31.
        String loadTimeSpan = "loadTimeSpan_example"; // String | Load time span (otherwise described as symbolic time span) defines a range of load dates. The load date is the date a record was added to the database. If load date is specified, the publishTimeSpan parameter must be omitted. If both publishTimeSpan and loadTimeSpan are omitted, the maximum publication date will be inferred from the editions data. Any of D/W/M/Y prefixed with a number where D-Day, M-Month, W-Week, Y-Year allowed. Acceptable value range for Day(0-6), Week(1-52), Month(1-12) and Year(0-10), ex: 5D,30W,10M,8Y.
        String sortField = "sortField_example"; // String | Order by field(s). Field name and order by clause separated by '+', use A for ASC and D for DESC, ex: PY+D. Multiple values are separated by comma.
        try {
            WosLiteResponse result = apiInstance.rootGet(databaseId, usrQuery, count, firstRecord, lang, edition, publishTimeSpan, loadTimeSpan, sortField);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SearchApi#rootGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **databaseId** | **String**| Database to search. Must be a valid database ID, one of the following: BCI/BIOABS/BIOSIS/CCC/DCI/DIIDW/MEDLINE/WOK/WOS/ZOOREC. WOK represents all databases. |
 **usrQuery** | **String**| User query for requesting data, ex: TS&#x3D;(cadmium). The query parser will return errors for invalid queries. |
 **count** | **Integer**| Number of records to return, must be 0-100. |
 **firstRecord** | **Integer**| Specific record, if any within the result set to return. Cannot be less than 1 and greater than 100000. |
 **lang** | **String**| Language of search. This element can take only one value: en for English. If no language is specified, English is passed by default. | [optional]
 **edition** | **String**| Edition(s) to be searched. If null, user permissions will be substituted. Must include the name of the collection and edition name separated by &#39;+&#39;, ex: WOS+SCI. Multiple editions are separated by &#39;,&#39;. Editions available for collection(WOS) - AHCI,CCR,IC,ISSHP,ISTP,SCI,SSCI,BHCI,BSCI and ESCI. | [optional]
 **publishTimeSpan** | **String**| This element specifies a range of publication dates. If publishTimeSpan is used, the loadTimeSpan parameter must be omitted. If publishTimeSpan and loadTimeSpan are both omitted, then the maximum time span will be inferred from the editions data. Beginning and end dates should be specified in the yyyy-mm-dd format separated by +, ex: 1993-01-01+2009-12-31. | [optional]
 **loadTimeSpan** | **String**| Load time span (otherwise described as symbolic time span) defines a range of load dates. The load date is the date a record was added to the database. If load date is specified, the publishTimeSpan parameter must be omitted. If both publishTimeSpan and loadTimeSpan are omitted, the maximum publication date will be inferred from the editions data. Any of D/W/M/Y prefixed with a number where D-Day, M-Month, W-Week, Y-Year allowed. Acceptable value range for Day(0-6), Week(1-52), Month(1-12) and Year(0-10), ex: 5D,30W,10M,8Y. | [optional]
 **sortField** | **String**| Order by field(s). Field name and order by clause separated by &#39;+&#39;, use A for ASC and D for DESC, ex: PY+D. Multiple values are separated by comma. | [optional]

### Return type

[**WosLiteResponse**](WosLiteResponse.md)

### Authorization

[key](../README.md#key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  * X-RateLimit-Remaining-second - The number of requests left for the second window. <br>  * X-RateLimit-Limit-second - The number of requests limit per second. <br>  * x-paginate-by-query-id - The url of the next page in case your &#x60;RecordsFound &gt; count + firstRecord&#x60; Please use this url for pagination. The QueryId will live for four hours in case if inactivity.  <br>  |
**0** | Error response 400+ |  * X-RateLimit-Remaining-second - The number of requests left for the second window. <br>  * X-RateLimit-Limit-second - The number of requests limit per second. <br>  |

