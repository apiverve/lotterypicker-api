declare module '@apiverve/lotterypicker' {
  export interface lotterypickerOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface lotterypickerResponse {
    status: string;
    error: string | null;
    data: LotteryNumberGeneratorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface LotteryNumberGeneratorData {
      game:             null | string;
      gameType:         null | string;
      config:           Config;
      ticketsGenerated: number | null;
      tickets:          Ticket[];
  }
  
  interface Config {
      mainNumbersCount:  number | null;
      mainNumbersRange:  null | string;
      bonusNumbersCount: number | null;
      bonusNumbersRange: null | string;
  }
  
  interface Ticket {
      ticketNumber: number | null;
      mainNumbers:  (number | null)[];
      bonusNumbers: (number | null)[];
  }

  export default class lotterypickerWrapper {
    constructor(options: lotterypickerOptions);

    execute(callback: (error: any, data: lotterypickerResponse | null) => void): Promise<lotterypickerResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: lotterypickerResponse | null) => void): Promise<lotterypickerResponse>;
    execute(query?: Record<string, any>): Promise<lotterypickerResponse>;
  }
}
