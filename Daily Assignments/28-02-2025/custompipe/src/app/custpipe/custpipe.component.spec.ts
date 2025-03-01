import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustpipeComponent } from './custpipe.component';

describe('CustpipeComponent', () => {
  let component: CustpipeComponent;
  let fixture: ComponentFixture<CustpipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustpipeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustpipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
