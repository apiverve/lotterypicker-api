/// Response models for the Lottery Number Generator API.

/// API Response wrapper.
class LotterypickerResponse {
  final String status;
  final dynamic error;
  final LotterypickerData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  LotterypickerResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory LotterypickerResponse.fromJson(Map<String, dynamic> json) => LotterypickerResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? LotterypickerData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Lottery Number Generator API.

class LotterypickerData {
  String? game;
  String? gameType;
  LotterypickerDataConfig? config;
  num? ticketsGenerated;
  List<LotterypickerDataTicketsItem>? tickets;

  LotterypickerData({
    this.game,
    this.gameType,
    this.config,
    this.ticketsGenerated,
    this.tickets,
  });

  factory LotterypickerData.fromJson(Map<String, dynamic> json) => LotterypickerData(
      game: json['game'],
      gameType: json['game_type'],
      config: json['config'] != null ? LotterypickerDataConfig.fromJson(json['config']) : null,
      ticketsGenerated: json['tickets_generated'],
      tickets: (json['tickets'] as List?)?.map((e) => LotterypickerDataTicketsItem.fromJson(e)).toList(),
    );
}

class LotterypickerDataConfig {
  num? mainNumbersCount;
  String? mainNumbersRange;
  num? bonusNumbersCount;
  String? bonusNumbersRange;

  LotterypickerDataConfig({
    this.mainNumbersCount,
    this.mainNumbersRange,
    this.bonusNumbersCount,
    this.bonusNumbersRange,
  });

  factory LotterypickerDataConfig.fromJson(Map<String, dynamic> json) => LotterypickerDataConfig(
      mainNumbersCount: json['main_numbers_count'],
      mainNumbersRange: json['main_numbers_range'],
      bonusNumbersCount: json['bonus_numbers_count'],
      bonusNumbersRange: json['bonus_numbers_range'],
    );
}

class LotterypickerDataTicketsItem {
  num? ticketNumber;
  List<num>? mainNumbers;
  List<num>? bonusNumbers;

  LotterypickerDataTicketsItem({
    this.ticketNumber,
    this.mainNumbers,
    this.bonusNumbers,
  });

  factory LotterypickerDataTicketsItem.fromJson(Map<String, dynamic> json) => LotterypickerDataTicketsItem(
      ticketNumber: json['ticket_number'],
      mainNumbers: (json['main_numbers'] as List?)?.cast<num>(),
      bonusNumbers: (json['bonus_numbers'] as List?)?.cast<num>(),
    );
}

class LotterypickerRequest {
  String? game;
  int? numbers;
  int? max;
  int? bonus;
  int? tickets;
  int? bonusmax;

  LotterypickerRequest({
    this.game,
    this.numbers,
    this.max,
    this.bonus,
    this.tickets,
    this.bonusmax,
  });

  Map<String, dynamic> toJson() => {
      if (game != null) 'game': game,
      if (numbers != null) 'numbers': numbers,
      if (max != null) 'max': max,
      if (bonus != null) 'bonus': bonus,
      if (tickets != null) 'tickets': tickets,
      if (bonusmax != null) 'bonusmax': bonusmax,
    };
}
