package com.example.server_driven_ui

object SampleJSON {

    // Page 1 — Profile tab (header, bio, highlights, posts)
    // Page 2 — Tagged tab
    val multiPage = """
        [
            {
                "alignment": "column",
                "content": [
                    {
                        "alignment": "row",
                        "content": [
                            {
                                "type": "image",
                                "value": "https://i.pravatar.cc/150"
                            },
                            {
                                "alignment": "column",
                                "content": [
                                    {
                                        "alignment": "row",
                                        "content": [
                                            {
                                                "alignment": "column",
                                                "content": [
                                                    { "type": "title", "value": "128" },
                                                    { "type": "description", "value": "Posts" }
                                                ]
                                            },
                                            {
                                                "alignment": "column",
                                                "content": [
                                                    { "type": "title", "value": "24.5K" },
                                                    { "type": "description", "value": "Followers" }
                                                ]
                                            },
                                            {
                                                "alignment": "column",
                                                "content": [
                                                    { "type": "title", "value": "312" },
                                                    { "type": "description", "value": "Following" }
                                                ]
                                            }
                                        ]
                                    }
                                ]
                            }
                        ]
                    },
                    {
                        "type": "title",
                        "value": "john.doe"
                    },
                    {
                        "type": "description",
                        "value": "📸 Photographer & traveller\n🌍 Exploring the world one frame at a time\n🔗 linktr.ee/johndoe"
                    },
                    {
                        "alignment": "row",
                        "content": [
                            {
                                "alignment": "column",
                                "content": [
                                    { "type": "image", "value": "https://picsum.photos/seed/h1/60/60" },
                                    { "type": "description", "value": "Travel" }
                                ]
                            },
                            {
                                "alignment": "column",
                                "content": [
                                    { "type": "image", "value": "https://picsum.photos/seed/h2/60/60" },
                                    { "type": "description", "value": "Food" }
                                ]
                            },
                            {
                                "alignment": "column",
                                "content": [
                                    { "type": "image", "value": "https://picsum.photos/seed/h3/60/60" },
                                    { "type": "description", "value": "Gear" }
                                ]
                            },
                            {
                                "alignment": "column",
                                "content": [
                                    { "type": "image", "value": "https://picsum.photos/seed/h4/60/60" },
                                    { "type": "description", "value": "Reels" }
                                ]
                            }
                        ]
                    },
                    {
                        "type": "horizontal_list",
                        "value": "posts_grid"
                    }
                ]
            },
            {
                "alignment": "column",
                "content": [
                    {
                        "type": "title",
                        "value": "Tagged"
                    },
                    {
                        "type": "description",
                        "value": "Photos and videos john.doe has been tagged in."
                    },
                    {
                        "type": "vertical_list",
                        "value": "tagged_posts"
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
