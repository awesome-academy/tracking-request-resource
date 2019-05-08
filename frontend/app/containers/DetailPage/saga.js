import { call, put, takeLatest } from 'redux-saga/effects';
import { fetchRequestInterviewFail, fetchRequestInterviewSuccess } from './actions';
import { FETCH_REQUEST_INTERVIEW } from './constants';
import request from 'utils/request';
import { urlApi } from 'utils/constants';

export function* getRequestInterviewFromApi(action) {
  const idRequest = action.idRequest;
  const requestURL = `${urlApi}/edu/requests/${idRequest}`;
  console.log(requestURL);
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
    yield put(fetchRequestInterviewFail(error.toString()));
  }
}

/**
 * Root saga manages watcher lifecycle
 */
export default function* detailPage() {
  yield takeLatest(FETCH_REQUEST_INTERVIEW, getRequestInterviewFromApi);
}
