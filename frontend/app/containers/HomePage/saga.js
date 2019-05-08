/**
 * Gets the repositories of the user from Github
 */

import { call, put, takeLatest } from 'redux-saga/effects';

import request from 'utils/request';
import { fetchRequestInterviewFail, fetchRequestInterviewSuccess } from './actions';
import { FETCH_REQUEST_INTERVIEW } from './constants';
import { urlApi } from 'utils/constants';


/**
 * fetch information of request job
 */

export function* getRequestInterviewFromApi() {

  const requestURL = `${urlApi}/edu/requests`;
  const token = localStorage.getItem('token');
  const options = {
    headers: {
      'Authorization': token,
    },
  };

  try {
    const request_interviews = yield call(request, requestURL, options);

    yield put(fetchRequestInterviewSuccess(request_interviews));
  } catch (error) {
    console.log('error:', new Error(error));
    yield put(fetchRequestInterviewFail(error.toString()));
  }
}

export function* watchInterview() {
  yield call(getRequestInterviewFromApi);
}

/**
 * Root saga manages watcher lifecycle
 */
export default function* job() {
  // yield fork(getRequestInterviewFromApi);
  yield takeLatest(FETCH_REQUEST_INTERVIEW, watchInterview);
}
