    package com.example.server_driven_ui

object SampleJSON {

    // Page 1 — Profile tab (header, bio, highlights, posts)
    // Page 2 — Tagged tab (banner centered, column content below)
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
                        "value": "Photographer and traveller. Exploring the world one frame at a time."
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
                        "type": "horizontal_grid",
                        "items": [
                            {
                                "title": "Sunset in Bali",
                                "description": "Golden hour magic",
                                "img": "https://picsum.photos/seed/p1/300/300"
                            },
                            {
                                "title": "Street Food Tokyo",
                                "description": "Ramen at midnight",
                                "img": "https://picsum.photos/seed/p2/300/300"
                            },
                            {
                                "title": "Alps Hiking",
                                "description": "Above the clouds",
                                "img": "https://picsum.photos/seed/p3/300/300"
                            },
                            {
                                "title": "Santorini Views",
                                "description": "Blue domes and white walls",
                                "img": "https://picsum.photos/seed/p4/300/300"
                            },
                            {
                                "title": "NYC Skyline",
                                "description": "City that never sleeps",
                                "img": "https://picsum.photos/seed/p5/300/300"
                            },
                            {
                                "title": "Safari Kenya",
                                "img": "https://picsum.photos/seed/p6/300/300"
                            }
                        ]
                    }
                ]
            },
            {
                "alignment": "box",
                "content": [
                  
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
                                "items": [
                                    {
                                        "title": "Tagged by @travel.world",
                                        "description": "Best travel photographer of 2024",
                                        "img": "https://picsum.photos/seed/t1/300/300"
                                    },
                                    {
                                        "title": "Tagged by @gearheads",
                                        "description": "Loving the new lens setup",
                                        "img": "https://picsum.photos/seed/t2/300/300"
                                    },
                                    {
                                        "title": "Tagged by @foodie.diaries",
                                        "description": "Spotted at the best ramen spot in town",
                                        "img": "https://picsum.photos/seed/t3/300/300"
                                    },
                                    {
                                        "title": "Tagged by @hikersunite",
                                        "img": "https://picsum.photos/seed/t4/300/300"
                                    }
                                ]
                            },
                              {
                              "type": "banner",
                              "title": "Creator of the Month",
                              "color": "yellow",
                              "description": "john.doe has been recognised as a top creator this month. Keep sharing your amazing work!",
                              "icon": "https://i.pravatar.cc/80",
                              "start_time": "2026-04-01T00:00:00Z",
                              "end_time": "2026-04-30T23:59:59Z"
                             },
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
