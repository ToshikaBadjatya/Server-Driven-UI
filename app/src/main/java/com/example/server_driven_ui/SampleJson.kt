package com.example.server_driven_ui

object SampleJSON {

    val multiPage1 = """
        [
            {
                "content": {
                    "type": "text",
                    "value": "Page 1"
                }
            },
            {
                "content": {
                    "type": "text",
                    "value": "Page 2"
                }
            }
        ]
    """.trimIndent()

    val singlePage1 = """
        {
            "content": {
                "type": "text",
                "value": "Page 1"
            }
        }
    """.trimIndent()
}
