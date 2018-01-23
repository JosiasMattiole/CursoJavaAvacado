import * as angular from 'angular';

import { default as uiRouter } from '@uirouter/angularjs';
import { mainConfig } from './main/config';
import { alunoConfig } from './alunos/aluno.config';
import { turmaConfig } from './turmas/turma.config';

export const appModule = 'webschool';

var modulo = angular.module(appModule, [uiRouter]);

modulo.config(mainConfig(modulo))
      .config(alunoConfig(modulo))
      .config(turmaConfig(modulo));
