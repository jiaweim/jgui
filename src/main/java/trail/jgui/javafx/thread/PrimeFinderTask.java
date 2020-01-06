/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package trail.jgui.javafx.thread;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 15 Jan 2018, 4:51 PM
 */
public class PrimeFinderTask extends Task<ObservableList<Long>>
{
    private long lowerLimit = 1;
    private long upperLimit = 30;
    private long sleepTimeInMillis = 500;

    public PrimeFinderTask() { }

    public PrimeFinderTask(long lowerLimit, long upperLimit)
    {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public PrimeFinderTask(long lowerLimit, long upperLimit, long sleepTimeInMillis)
    {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.sleepTimeInMillis = sleepTimeInMillis;
    }

    @Override
    protected ObservableList<Long> call() throws Exception
    {
        ObservableList<Long> results = FXCollections.observableArrayList();

        updateTitle("Prime Number Finder Task");

        long count = upperLimit - lowerLimit + 1;
        long counter = 0;

        // Find the prime numbers
        for (long i = lowerLimit; i <= upperLimit; i++) {

            if (isCancelled())
                break;

            counter++;

            updateMessage("Checking " + i + " for a prime number");

            try {
                Thread.sleep(sleepTimeInMillis);
            } catch (InterruptedException e) {
                if (isCancelled())
                    break;
            }

            if (PrimeUtil.isPrime(i)) {
                results.add(i);
                updateValue(FXCollections.unmodifiableObservableList(results));
            }

            updateProgress(counter, count);
        }

        return results;
    }

    @Override
    protected void succeeded()
    {
        super.succeeded();
        updateMessage("The task finished successfully.");
    }

    @Override
    protected void cancelled()
    {
        super.cancelled();
        updateMessage("The task was cancelled.");
    }

    @Override
    protected void failed()
    {
        super.failed();
        updateMessage("The task failed.");
    }
}
