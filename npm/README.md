# Lottery Number Generator API

Lottery Number Generator creates random lottery numbers for various popular games including Powerball, Mega Millions, EuroMillions, and custom lottery configurations.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)
[![npm version](https://img.shields.io/npm/v/@apiverve/lotterypicker.svg)](https://www.npmjs.com/package/@apiverve/lotterypicker)

This is a Javascript Wrapper for the [Lottery Number Generator API](https://apiverve.com/marketplace/lotterypicker?utm_source=npm&utm_medium=readme)

---

## Installation

Using npm:
```shell
npm install @apiverve/lotterypicker
```

Using yarn:
```shell
yarn add @apiverve/lotterypicker
```

---

## Configuration

Before using the Lottery Number Generator API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=npm&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=npm&utm_medium=readme)

The Lottery Number Generator API documentation is found here: [https://docs.apiverve.com/ref/lotterypicker](https://docs.apiverve.com/ref/lotterypicker?utm_source=npm&utm_medium=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

```javascript
const lotterypickerAPI = require('@apiverve/lotterypicker');
const api = new lotterypickerAPI({
    api_key: '[YOUR_API_KEY]'
});
```

---

## Usage

---

### Perform Request

Using the API is simple. All you have to do is make a request. The API will return a response with the data you requested.

```javascript
var query = {
  game: "custom",
  numbers: 6,
  max: 49,
  bonus: 0,
  tickets: 1
};

api.execute(query, function (error, data) {
    if (error) {
        return console.error(error);
    } else {
        console.log(data);
    }
});
```

---

### Using Promises

You can also use promises to make requests. The API returns a promise that you can use to handle the response.

```javascript
var query = {
  game: "custom",
  numbers: 6,
  max: 49,
  bonus: 0,
  tickets: 1
};

api.execute(query)
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error(error);
    });
```

---

### Using Async/Await

You can also use async/await to make requests. The API returns a promise that you can use to handle the response.

```javascript
async function makeRequest() {
    var query = {
  game: "custom",
  numbers: 6,
  max: 49,
  bonus: 0,
  tickets: 1
};

    try {
        const data = await api.execute(query);
        console.log(data);
    } catch (error) {
        console.error(error);
    }
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
          11,
          12,
          51,
          53,
          58
        ],
        "bonus_numbers": [
          3
        ]
      },
      {
        "ticket_number": 2,
        "main_numbers": [
          4,
          24,
          28,
          46,
          61
        ],
        "bonus_numbers": [
          3
        ]
      },
      {
        "ticket_number": 3,
        "main_numbers": [
          12,
          13,
          29,
          49,
          60
        ],
        "bonus_numbers": [
          6
        ]
      }
    ]
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=npm&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=npm&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=npm&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=npm&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
