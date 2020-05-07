// This file is required by karma.conf.js and loads recursively all the .spec and framework files

import 'zone.js/dist/zone-testing';
import { getTestBed } from '@angular/core/testing';
import {
  BrowserDynamicTestingModule,
  platformBrowserDynamicTesting
} from '@angular/platform-browser-dynamic/testing';

declare const require: {
  context(path: string, deep?: boolean, filter?: RegExp): {
    keys(): string[];
    <T>(id: string): T;
  };
};

// First, initialize the Angular testing environment.
getTestBed().initTestEnvironment(
  BrowserDynamicTestingModule,
  platformBrowserDynamicTesting()
);
// Then we find all the tests.
<<<<<<< HEAD
const context = require.context('./app/components/login', true, /\.spec\.ts$/);
=======
const context = require.context('./app/services', true, /\.spec\.ts$/);
>>>>>>> b00ff8391bb17bf007f39e4b95af3faeda305e49
// And load the modules.
context.keys().map(context);
