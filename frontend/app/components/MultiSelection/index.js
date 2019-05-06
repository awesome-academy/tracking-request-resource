/**
 *
 * MultiSelection
 *
 */

import React from 'react';
// import PropTypes from 'prop-types';
// import styled from 'styled-components';

import { FormattedMessage } from 'react-intl';
import messages from './messages';

/* eslint-disable react/prefer-stateless-function */
class MultiSelection extends React.Component {
  constructor(props) {
    super(props);

    this.defaultOptions = this.props.options;
    this.state = {
      stateSelectLeft: this.defaultOptions,
      stateSelectRight: [],

      //save state of search before forcus input search
      stateSearchLeft: this.defaultOptions,
      stateSearchRight: [],
    };
  }

  selectItemLeft = (e) => {
    const item = e.target;
    this.setState({
      stateSelectLeft: this.state.stateSelectLeft.filter(state => state.value != item.value),
      stateSelectRight: [...this.state.stateSelectRight, { value: item.value, label: item.label }],
    });
  };

  selectMultiItemLeft = (e) => {
    const select = this.selectLeft;
    let all_options = [].filter.call(select.options, o => o.selected).map(o => {
      return { value: o.value, label: o.label };
    });
    let stateSelectLeftSave = this.state.stateSelectLeft;

    all_options.map(item => {
      stateSelectLeftSave = stateSelectLeftSave.filter(state => state.value != item.value);
      this.state.stateSelectRight.push({ label: item.label, value: item.value });
    });
    this.setState({
      stateSelectLeft: stateSelectLeftSave,
      stateSelectRight: this.state.stateSelectRight,
    });
  };
  selectAllItemLeft = (e) => {
    this.setState({
      //concat : immutable function
      stateSelectRight: this.state.stateSelectRight.concat(this.state.stateSelectLeft),
      stateSelectLeft: [],
    });
    console.log(this.state.stateSelectRight);
  };

  selectItemRight = (e) => {
    const item = e.target;
    this.setState({
      stateSelectRight: this.state.stateSelectRight.filter(state => state.value != item.value),
      stateSelectLeft: [...this.state.stateSelectLeft, { value: item.value, label: item.label }],
    });
  };

  selectMultiItemRight = (e) => {
    const select = this.selectRight;
    let all_options = [].filter.call(select.options, o => o.selected).map(o => {
      return { value: o.value, label: o.label };
    });
    let stateSelectRightSave = this.state.stateSelectRight;

    all_options.map(item => {
      stateSelectRightSave = stateSelectRightSave.filter(state => state.value != item.value);
      this.state.stateSelectLeft.push({ label: item.label, value: item.value });
    });
    this.setState({
      stateSelectRight: stateSelectRightSave,
      stateSelectLeft: this.state.stateSelectLeft,
    });
  };

  selectAllItemRight = (e) => {
    this.setState({
      stateSelectLeft: this.state.stateSelectLeft.concat(this.state.stateSelectRight),
      stateSelectRight: [],
    });

  };

  /**
   *  Search Item
   */

  saveStateLeft = () => {
    this.setState({
      stateSearchLeft: this.state.stateSelectLeft,
    });
  };

  searchItemLeft = (e) => {
    let updateList = this.state.stateSearchLeft;

    updateList = updateList.filter(item => {
      return item.label.toLowerCase().search(e.target.value.toLowerCase()) != '-1';
    });
    
    this.setState({
      stateSelectLeft: updateList,
    });
  };


  saveStateRight = () => {
    this.setState({
      stateSearchRight: this.state.stateSelectRight,
    });
  };

  searchItemRight = (e) => {
    let updateList = this.state.stateSearchRight;

    updateList = updateList.filter(item => {
      return item.label.toLowerCase().search(e.target.value.toLowerCase()) != -1;
    });
    this.setState({
      stateSelectRight: updateList,
    });
  };

  /**
   * add Item
   */
  clickAdd() {
    this.props.clickAddMutliSelect(this.state.stateSelectRight);
  }

  render() {
    const { selected } = this.state;
    return (
      <div>
        <div className="modal fade" id="addTraineeForRequest" tabIndex="-1" role="dialog"
             aria-hidden="true">
          <div className="modal-dialog" role="document">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title">{this.props.title}</h5>
                <button className="close" type="button" data-dismiss="modal" aria-label="Close"><span
                  aria-hidden="true">×</span>
                </button>
              </div>

              <div className="modal-body">
                <div className="container-fluid">
                  <div className="row">
                    <div className="col">
                      <input className="form-control mb-2" placeholder="search" onChange={(e) => this.searchItemLeft(e)}
                             onClick={this.saveStateLeft}/>

                      <select className="custom-select" multiple onDoubleClick={(e) => this.selectItemLeft(e)}
                              ref={value => this.selectLeft = value}>
                        {this.state.stateSelectLeft.map((item, index) =>
                          <option key={item.index} value={item.value} label={item.label}>{item.label}</option>,
                        )}
                      </select>
                      <div className="mt-2">
                        <button onClick={this.selectMultiItemLeft}><i className="fas fa-arrow-circle-right"
                                                                      style={{ fontSize: '22px' }}></i></button>
                        <button onClick={this.selectAllItemLeft}><i className="fas fa-angle-double-right "
                                                                    style={{ fontSize: '22px' }}></i></button>
                      </div>
                    </div>
                    <div className="col">
                      <input className="form-control mb-2" placeholder="search"
                             onChange={(e) => this.searchItemRight(e)} onClick={this.saveStateRight}/>
                      <select className="custom-select" multiple onDoubleClick={(e) => this.selectItemRight(e)}
                              ref={value => this.selectRight = value}>
                        {this.state.stateSelectRight.map((item, index) =>
                          <option key={item.index} value={item.value} label={item.label}>{item.label}</option>,
                        )}
                      </select>
                      <div className="mt-2">
                        <button onClick={this.selectMultiItemRight}><i className="fas fa-arrow-circle-left"
                                                                       style={{ fontSize: '22px' }}></i></button>
                        <button onClick={this.selectAllItemRight}><i className="fas fa-angle-double-left"
                                                                     style={{ fontSize: '22px' }}></i></button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div className="modal-footer">
                <button className="btn btn-danger" onClick={() => this.clickAdd()}>Ok</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

MultiSelection.propTypes = {};

export default MultiSelection;
