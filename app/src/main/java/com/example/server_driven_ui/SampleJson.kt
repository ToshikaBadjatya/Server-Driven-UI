package com.example.server_driven_ui

object SampleJSON {

    val multiPage = """
        [
            {
                "alignment": "column",
                "content": [
                    {
                        "type": "title",
                        "value": "Welcome to Page 1"
                    },
                    {
                        "alignment": "row",
                        "content": [
                            {
                                "type": "title",
                                "value": "Feature A"
                            },
                            {
                                "type": "description",
                                "value": "This is a short summary of Feature A sitting next to its label."
                            }
                        ]
                    },
                    {
                        "alignment": "box",
                        "content": [
                            {
                                "type": "webpage",
                                "value": "https://www.google.com"
                            },
                            {
                                "type": "title",
                                "value": "Overlay Title"
                            }
                        ]
                    },
                    {
                        "type": "description",
                        "value": "This description sits below the box as a footer note for page 1."
                    }
                ]
            },
            {
                "alignment": "column",
                "content": [
                    {
                        "type": "title",
                        "value": "Welcome to Page 2"
                    },
                    {
                        "type": "description",
                        "value": "Page 2 gives you a deeper look into the details of this section."
                    },
                    {
                        "alignment": "row",
                        "content": [
                            {
                                "type": "description",
                                "value": "Left column info"
                            },
                            {
                                "type": "description",
                                "value": "Right column info"
                            }
                        ]
                    },
                    {
                        "alignment": "box",
                        "content": [
                            {
                                "type": "webpage",
                                "value": "https://www.github.com"
                            },
                            {
                                "type": "description",
                                "value": "Powered by GitHub"
                            }
                        ]
                    }
                ]
            }
        ]
    """.trimIndent()

    val singlePage = """
        {
            "alignment": "column",
            "content": [
                {
                    "type": "title",
                    "value": "Single Page View"
                },
                {
                    "type": "description",
                    "value": "This is the only page in single page mode."
                },
                {
                    "alignment": "row",
                    "content": [
                        {
                            "type": "title",
                            "value": "Info"
                        },
                        {
                            "type": "description",
                            "value": "Some detail next to the label."
                        }
                    ]
                }
            ]
        }
    """.trimIndent()
}
