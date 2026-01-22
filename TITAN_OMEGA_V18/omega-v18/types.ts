
export enum StrikeStatus {
  COMPLETED = 'COMPLETED',
  IN_PROGRESS = 'IN_PROGRESS',
  PENDING = 'PENDING',
  FAILED = 'FAILED'
}

export enum Priority {
  LOW = 'LOW',
  MEDIUM = 'MEDIUM',
  HIGH = 'HIGH'
}

export type SupportedLanguage = 'AR' | 'EN' | 'ZH' | 'RU' | 'ES' | 'FR' | 'JA' | 'DE' | 'TR' | 'HI' | 'PT';

export interface LegalStrike {
  id: string;
  entity: string;
  platform: string;
  status: StrikeStatus;
  timestamp: string;
  description: string;
  type: 'MEDIA' | 'LEGAL' | 'GOVERNMENT';
  priority: Priority;
  caseId: string;
}

export interface Evidence {
  id: string;
  title: string;
  type: 'DOCUMENT' | 'LOG' | 'CODE' | 'TRANSACTION';
  severity: 'CRITICAL' | 'HIGH' | 'MEDIUM';
  summary: string;
  priority: Priority;
  caseId: string;
  details?: string;
}

export interface Case {
  id: string;
  title: string;
  description: string;
}

export interface ChatMessage {
  role: 'user' | 'model';
  content: string;
  timestamp: Date;
  thinking?: string;
  groundingUrls?: Array<{ uri: string; title: string }>;
}
