# Lottery Number Generator API - Dart/Flutter Client

Lottery Number Generator creates random lottery numbers for various popular games including Powerball, Mega Millions, EuroMillions, and custom lottery configurations.

[![pub package](https://img.shields.io/pub/v/apiverve_lotterypicker.svg)](https://pub.dev/packages/apiverve_lotterypicker)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Lottery Number Generator API](https://apiverve.com/marketplace/lotterypicker?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_lotterypicker: ^1.2.5
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_lotterypicker/apiverve_lotterypicker.dart';

void main() async {
  final client = LotterypickerClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'game': 'custom',
      'numbers': 6,
      'max': 49,
      'bonus': 1,
      'tickets': 1,
      'bonusmax': 10
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Lottery Number Generator API](https://apiverve.com/marketplace/lotterypicker?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/lotterypicker](https://docs.apiverve.com/ref/lotterypicker?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
