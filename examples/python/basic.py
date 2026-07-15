"""
Lottery Number Generator API - Basic Usage Example

This example demonstrates the basic usage of the Lottery Number Generator API.
API Documentation: https://docs.apiverve.com/ref/lotterypicker
"""

import os
import requests
import json

API_KEY = os.getenv('APIVERVE_API_KEY', 'YOUR_API_KEY_HERE')
API_URL = 'https://api.apiverve.com/v1/lotterypicker'

def call_lotterypicker_api():
    """
    Make a GET request to the Lottery Number Generator API
    """
    try:
        # Query parameters
        params &#x3D; {&#x27;game&#x27;: &#x27;powerball&#x27;, &#x27;numbers&#x27;: 6, &#x27;max&#x27;: 49, &#x27;bonus&#x27;: 1, &#x27;tickets&#x27;: 3}

        headers = {
            'x-api-key': API_KEY
        }

        response = requests.get(API_URL, headers=headers, params=params)

        # Raise exception for HTTP errors
        response.raise_for_status()

        data = response.json()

        # Check API response status
        if data.get('status') == 'ok':
            print('✓ Success!')
            print('Response data:', json.dumps(data['data'], indent=2))
            return data['data']
        else:
            print('✗ API Error:', data.get('error', 'Unknown error'))
            return None

    except requests.exceptions.RequestException as e:
        print(f'✗ Request failed: {e}')
        return None

if __name__ == '__main__':
    print('📤 Calling Lottery Number Generator API...\n')

    result = call_lotterypicker_api()

    if result:
        print('\n📊 Final Result:')
        print(json.dumps(result, indent=2))
    else:
        print('\n✗ API call failed')
