# Lottery Number Generator API - Go Client

Lottery Number Generator creates random lottery numbers for various popular games including Powerball, Mega Millions, EuroMillions, and custom lottery configurations.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Go client for the [Lottery Number Generator API](https://apiverve.com/marketplace/lotterypicker?utm_source=go&utm_medium=readme)

---

## Installation

```bash
go get github.com/apiverve/lotterypicker-api/go
```

---

## Configuration

Before using the Lottery Number Generator API client, you need to obtain your API key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=go&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=go&utm_medium=readme)

The Lottery Number Generator API documentation is found here: [https://docs.apiverve.com/ref/lotterypicker](https://docs.apiverve.com/ref/lotterypicker?utm_source=go&utm_medium=readme)

---

## Usage

```go
package main

import (
    "fmt"
    "log"

    "github.com/apiverve/lotterypicker-api/go"
)

func main() {
    // Create a new client
    client := lotterypicker.NewClient("YOUR_API_KEY")

    // Set up parameters
    params := map[string]interface{}{
        "game": "custom",
        "numbers": 6,
        "max": 49,
        "bonus": 1,
        "tickets": 1
    }

    // Make the request
    response, err := client.Execute(params)
    if err != nil {
        log.Fatal(err)
    }

    fmt.Printf("Status: %s\n", response.Status)
    fmt.Printf("Data: %+v\n", response.Data)
}
```

---

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "game": "Powerball (US)",
    "game_type": "powerball",
    "config": {
      "main_numbers_count": 5,
      "main_numbers_range": "1-69",
      "bonus_numbers_count": 1,
      "bonus_numbers_range": "1-26"
    },
    "tickets_generated": 3,
    "tickets": [
      {
        "ticket_number": 1,
        "main_numbers": [
          24,
          27,
          65,
          66,
          69
        ],
        "bonus_numbers": [
          11
        ]
      },
      {
        "ticket_number": 2,
        "main_numbers": [
          2,
          12,
          40,
          55,
          64
        ],
        "bonus_numbers": [
          4
        ]
      },
      {
        "ticket_number": 3,
        "main_numbers": [
          11,
          29,
          35,
          43,
          46
        ],
        "bonus_numbers": [
          8
        ]
      }
    ],
    "available_games": [
      "custom",
      "powerball",
      "megamillions",
      "euromillions",
      "eurojackpot",
      "lotto649"
    ]
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=go&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=go&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=go&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=go&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
