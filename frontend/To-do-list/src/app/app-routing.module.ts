import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './component/connexion/connexion.component';
import { InscriptionComponent } from './component/inscription/inscription.component';

const routes: Routes = [
  { path: 'connexion', component: ConnexionComponent },
  { path: '', redirectTo: '/connexion', pathMatch: 'full' },
  { path: 'inscription', component: InscriptionComponent },
  {
    path: 'user',
    loadChildren: () =>
      import('./dashboard-user/user/user-routing.module').then(
        (m) => m.UserRoutingModule
      ),
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
