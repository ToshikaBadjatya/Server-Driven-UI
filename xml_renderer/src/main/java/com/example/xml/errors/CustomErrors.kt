package com.example.xml.errors

sealed class CustomErrors(
    open val msg: String
) : Exception(msg) {

    // UI rendering / schema issues
    data object InvalidConstraints : CustomErrors(
        "JSON constraints invalid to render"
    )

    data class FieldErrors(
        val fieldName: String
    ) : CustomErrors(
        "Error in field: $fieldName"
    )

    // Parsing / mapping issues
    data class ParsingError(
        val rawResponse: String
    ) : CustomErrors(
        "Failed to parse server response"
    )
    data class UrlHandling(
        val rawUrl: String
    ) : CustomErrors(
        "Invalid webView url $rawUrl"
    )

    // Fallback
    data object Unknown : CustomErrors(
        "Something went wrong"
    )

}
