export interface ILine {
  id?: number;
  uar?: boolean;
}

export class Line implements ILine {
  constructor(public id?: number, public uar?: boolean) {
    this.uar = this.uar || false;
  }
}
