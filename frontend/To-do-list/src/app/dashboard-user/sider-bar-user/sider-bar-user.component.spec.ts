import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SiderBarUserComponent } from './sider-bar-user.component';

describe('SiderBarUserComponent', () => {
  let component: SiderBarUserComponent;
  let fixture: ComponentFixture<SiderBarUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SiderBarUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SiderBarUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
