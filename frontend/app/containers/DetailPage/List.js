import React, { Component } from 'react';
import messages from './messages';
import { FormattedMessage } from 'react-intl';
import MultiSelection from '../../components/MultiSelection/Loadable';

export default class List extends Component {
  constructor(props) {
    super(props);
  }

  clickAdd = (e) => {
    console.log('add', e);
  };

  render() {
    const { requestTrainees, error, loading } = this.props;
    console.log(requestTrainees);
    return (

      <div className="list col-12 bg-white mb-3 border rounded-lg mt-3">
        <div className="list__header text-left py-3 border-bottom">
          <div className="row align-items-center">
            <div className="text-left col">
              <i className="fa fa-bars mr-2"></i>
              <b><FormattedMessage {...messages.titleContainerListTrainee}/></b><sup
              className="badge badge-primary">{requestTrainees && requestTrainees.length}</sup></div>
            <div className="text-right col">
              <button className="btn rounded-pill mr-1" data-toggle="modal" data-target="#addTraineeForRequest">
                <i className="fa fa-pencil-alt pr-2"></i>
                <span><FormattedMessage {...messages.edit}/></span>
              </button>
            </div>
          </div>
        </div>
        <div className="mail__content border rounded-lg pt-2 mt-4 mb-3">
          <div className="container-fluid">
            <div className="row">
              <div className="col">
                {error}
                {loading && <FormattedMessage {...messages.loading}/>}
                {requestTrainees &&
                <div>
                  {requestTrainees.length == 0 ?
                    <div className="text-center text-danger"><FormattedMessage {...messages.noData}/></div>
                    :
                    <div className="table-responsive">
                      <table className="table table-bordered table-hover table-striped table-vcenter text-center">
                        <thead>
                        <tr>
                          <th scope="row"><span><FormattedMessage {...messages.noTrainee}/></span></th>
                          <th scope="row"><span><FormattedMessage {...messages.nameTrainee}/></span></th>
                          <th scope="row"><span><FormattedMessage {...messages.languageTrainee}/></span></th>
                          <th scope="row"><span><FormattedMessage {...messages.emailTrainee}/></span></th>
                          <th scope="row"><span><FormattedMessage {...messages.officeTrainee}/></span></th>
                          {/*<th scope="row"><span><FormattedMessage {...messages.trainerTrainee}/></span></th>*/}
                          <th scope="row"><span><FormattedMessage {...messages.statusTrainee}/></span></th>
                          <th scope="row"><span><FormattedMessage {...messages.actionTrainee}/></span></th>
                        </tr>
                        </thead>
                        <tbody>
                        {requestTrainees.map((request, index) =>
                          <tr key={request.id}>
                            <td>{index + 1}</td>
                            <td className="visible-lg">{request.trainee.name}</td>
                            <td>{request.trainee.language}</td>
                            <td>{request.trainee.email}</td>
                            <td>{request.trainee.office}</td>
                            {/*<td><span className="font-weight-bold">{trainee.trainer.name}</span></td>*/}
                            <td><span className="badge badge-warning">{request.trainee.status}</span></td>
                            <td>
                              <div className="btn-group btn-group-xs">
                                <button className="btn btn-default px-0"><a href="#"><i
                                  className="fa fa-eye text-warning"></i></a></button>
                              </div>
                              <div className="btn-group btn-group-xs">
                                <button className="btn btn-default px-0" data-toggle="modal" data-target="#delete">
                                  <div className="fa fa-trash text-danger"></div>
                                </button>
                              </div>
                            </td>
                          </tr>,
                        )}
                        </tbody>
                      </table>

                    </div>
                  }
                </div>
                }
              </div>

            </div>
          </div>
        </div>
        <MultiSelection options={options} clickAddMutliSelect={this.clickAdd} title="Add trainees to request"/>
      </div>
    );
  }
}

const options = [
  { value: 'one', label: 'trainee 1' },
  { value: 'two', label: 'trainee 2' },
  { value: '3', label: 'trainee 3' },
  { value: '4', label: 'trainee 4' },
  { value: '5', label: 'trainee 5' },
];
