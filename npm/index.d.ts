declare module '@apiverve/lotterypicker' {
  export interface lotterypickerOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface lotterypickerResponse {
    status: string;
    error: string | null;
    data: LotteryNumberGeneratorData;
    code?: number;
  }


  interface LotteryNumberGeneratorData {
      game:             string;
      gameType:         string;
      config:           Config;
      ticketsGenerated: number;
      tickets:          Ticket[];
      availableGames:   string[];
  }
  
  interface Config {
      mainNumbersCount:  number;
      mainNumbersRange:  string;
      bonusNumbersCount: number;
      bonusNumbersRange: string;
  }
  
  interface Ticket {
      ticketNumber: number;
      mainNumbers:  number[];
      bonusNumbers: number[];
  }

  export default class lotterypickerWrapper {
    constructor(options: lotterypickerOptions);

    execute(callback: (error: any, data: lotterypickerResponse | null) => void): Promise<lotterypickerResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: lotterypickerResponse | null) => void): Promise<lotterypickerResponse>;
    execute(query?: Record<string, any>): Promise<lotterypickerResponse>;
  }
}
