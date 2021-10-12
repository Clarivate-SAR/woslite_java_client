# Web of Science API Lite Java Client

Web of Science API Lite
- API version: 1.0
  - Build date: 2021-06-02T10:06:41.554+02:00[Europe/Berlin]

A responsive API that supports rich searching across the Web of Science Core Collection to retrieve core article metadata. 
This service provides a great way to reuse Web of Science data both internally and externally to enhance 
institutional repositories and research networking systems with best-in-class data.
This API supports searching across the Web of Science to retrieve item-level
metadata with limited fields: 
- UT (Unique Identifier)
- Authors
- Author keywords
- Document type
- Title
- Issue
- Pages
- Publication date
- Source title
- Volume
- DOI
- ISBN
- ISSN 

The API supports JSON and XML responses, and this client supports JSON only.




## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

Clone the repository and include in your project




### Others

At first generate the JAR by executing:

```shell
gradlew clean build
```



## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

package example;

// Import classes:
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

```

## Documentation for API Endpoints

All URIs are relative to *https://api.clarivate.com/api/woslite*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*IntegrationApi* | [**idUniqueIdGet**](docs/IntegrationApi.md#idUniqueIdGet) | **GET** /id/{uniqueId} | Find record(s) by specific id
*SearchApi* | [**queryQueryIdGet**](docs/SearchApi.md#queryQueryIdGet) | **GET** /query/{queryId} | Fetch record(s) by query identifier
*SearchApi* | [**rootGet**](docs/SearchApi.md#rootGet) | **GET** / | Submits a user query and returns results


## Documentation for Models

 - [Author](docs/Author.md)
 - [Doctype](docs/Doctype.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [Keyword](docs/Keyword.md)
 - [Other](docs/Other.md)
 - [QueryResult](docs/QueryResult.md)
 - [Source](docs/Source.md)
 - [WosLiteRecord](docs/WosLiteRecord.md)
 - [WosLiteRecordTitle](docs/WosLiteRecordTitle.md)
 - [WosLiteResponse](docs/WosLiteResponse.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### key

- **Type**: API key
- **API key parameter name**: X-ApiKey
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author
Web of Science APIs Product team



